package qef.map;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import qef.Konstantj;
import qef.QefObjektj;
import qef.dijkstra.Dijkstra;
import qef.estazhj.Estazhregistril;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;
import qef.inventar.Objekt;
import qef.inventar.Objektar;
import qef.inventar.Objektregistril;
import qef.sprite.SpriteFoli;

public class Map {
	
	private int tileeMaplargx;
	private int tileeMapalt;

	public int komencpunktX;
	public int komencpunktY;
	
	private ArrayList<Spritetavol> spritetavolj;
	
	public ArrayList<Rectangle> arejKolici;
	public ArrayList<Rectangle> gxisdatigitArejKolici;
	
	private BufferedImage[] paletrsprite;
	
	private Dijkstra d;
	
	public ArrayList<Objektar> objektarj;
	public ArrayList<Vivazh> vivazhar;

	public Map(final int itener) {
		String enhav = YargxilAzhj.yargxTextn(Konstantj.ITENER_MAP + itener + ".tmx");
		
		final JSONObject globalJSON = JSONObjektn(enhav);
		tileeMaplargx = intAlJSONn(globalJSON, "width");
		tileeMapalt = intAlJSONn(globalJSON, "height");
		
		final JSONObject komencPunkt = JSONObjektn(globalJSON.get("start").toString());
		komencpunktX = intAlJSONn(komencPunkt, "x"); 
		komencpunktY = intAlJSONn(komencPunkt, "y");
		
		final JSONArray tavolj = JSONArrayn(globalJSON.get("layers").toString());
		
		spritetavolj = new ArrayList<>();
		final ArrayList<Kolizitavol> kolizitavolj = new ArrayList<>();
		
		//INICIAR CAPAS
		for (int i = 0; i < tavolj.size(); i++) {
			JSONObject tavoldatumj = JSONObjektn(tavolj.get(i).toString());

//			int anchoCapa = obtenerIntDesdeJSON(datosCapa, "width");TODO MI PETEGAS VIN(MIN) KE "FIX"-U CXI TIO
//			int altoCapa = obtenerIntDesdeJSON(datosCapa, "height");
			int tavollargx = tileeMaplargx;
			int tavolalt = tileeMapalt;
			int tavolX = intAlJSONn(tavoldatumj, "x");
			int tavolY = intAlJSONn(tavoldatumj, "y");
			
			switch(tavoldatumj.get("type").toString()) {
			case "tilelayer":
				JSONArray spritej = JSONArrayn(tavoldatumj.get("data").toString());
				int[] spritejTavol = new int[spritej.size()];
				for (int j = 0; j< spritej.size(); j++) {
					int spriteId = Integer.parseInt(spritej.get(j).toString());
					spritejTavol[j] = spriteId - 1;
				}
				spritetavolj.add(new Spritetavol(tavollargx, tavolalt, tavolX, tavolY, spritejTavol));
				break;
			case "objectgroup":
				JSONArray rectangulos = JSONArrayn(tavoldatumj.get("objects").toString());
				Rectangle[] rectangulosCapa = new Rectangle[rectangulos.size()];
				for (int j = 0; j < rectangulos.size(); j++) {
					JSONObject datosRectangulo = JSONObjektn(rectangulos.get(j).toString());
					
					int x = intAlJSONn(datosRectangulo, "x");
					int y = intAlJSONn(datosRectangulo, "y");
					int largx = intAlJSONn(datosRectangulo, "width");
					int alt = intAlJSONn(datosRectangulo, "height");
					/*boolean qtransenebl = false;
					if(datosRectangulo.get("properties")!=null) {
						JSONObject pasable = JSONObjektn(datosRectangulo.get("properties").toString());
						String passable = pasable.get("passable").toString();
						qtransenebl = passable != null && passable.equals("true");
					}
					System.out.println(qtransenebl);*/
					if (x == 0) x = 1;
					if (y == 0) y = 1;
					if (largx == 0) largx = 1;
					if (alt == 0) alt = 1;
					
					Rectangle rectangulo = new Rectangle(x, y, largx, alt);
					rectangulosCapa[j] = rectangulo;
				}
				kolizitavolj.add(new Kolizitavol(tavollargx, tavolalt, tavolX, tavolY, rectangulosCapa));
				
				break;
			}
		}
		
		//COMBINAR COLISIONES EN UN SOLO ARRAYLIST POR EFICIENCIA
		arejKolici = new ArrayList<>();
		for (int i = 0; i < kolizitavolj.size(); i++) {
			Rectangle[] rectangulos = kolizitavolj.get(i).obtenerColisionables();
			
			for (int j = 0; j < rectangulos.length; j++) {
				arejKolici.add(rectangulos[j]);
			}
		}
		
		d = new Dijkstra(new Point(komencpunktX, komencpunktY), tileeMaplargx, tileeMapalt, arejKolici);
		//AVERIGUAR TOTAL DE SPRITES EXISTENTES EN TODAS LAS CAPAS
		JSONArray coleccionesSprites = JSONArrayn(globalJSON.get("tilesets").toString());
		int totalSprites = 0;
		for (int i = 0; i < coleccionesSprites.size(); i++) {
			JSONObject datosGrupo = JSONObjektn(coleccionesSprites.get(i).toString());
			totalSprites += intAlJSONn(datosGrupo, "tilecount");
		}
		paletrsprite = new BufferedImage[totalSprites];
		
		//ASIGNAR SPRITES NECESARIOS A LA PALETA A PARTIR DE LAS CAPAS
		for (int i = 0; i < coleccionesSprites.size(); i++) {
			JSONObject datosGrupo = JSONObjektn(coleccionesSprites.get(i).toString());
			
			int anchoTiles = intAlJSONn(datosGrupo, "tilewidth");
			SpriteFoli hoja = new SpriteFoli(Konstantj.ITENER_TILESET_MAP + datosGrupo.get("image").toString(),
					anchoTiles, Transparency.BITMASK);
			
			int primerSpriteColeccion = intAlJSONn(datosGrupo, "firstgid") - 1;
			int ultimoSpriteColeccion = primerSpriteColeccion + intAlJSONn(datosGrupo, "tilecount") - 1;
			
			for (int j = 0; j < this.spritetavolj.size(); j++) {
				Spritetavol capaActual = this.spritetavolj.get(j);
				int[] spritesCapa = capaActual.obtenerArraySprites();
				
				for (int k = 0; k < spritesCapa.length; k++) {
					int idSpriteActual = spritesCapa[k];
					if (idSpriteActual >= primerSpriteColeccion && idSpriteActual <= ultimoSpriteColeccion) {
						if (paletrsprite[idSpriteActual] == null) {
							paletrsprite[idSpriteActual] = hoja.spritejn(idSpriteActual - primerSpriteColeccion);
						}
					}
				}
			}	
		}
		
		//OBTENER OBJETOS
		objektarj = new ArrayList<>();
		JSONArray coleccionObjetos = JSONArrayn(globalJSON.get("objetos").toString());
		for (int i = 0; i < coleccionObjetos.size(); i++) {
			JSONObject datosObjeto = JSONObjektn(coleccionObjetos.get(i).toString());
			
			int idObjeto = intAlJSONn(datosObjeto, "id");
			int cantidadObjeto = intAlJSONn(datosObjeto, "cantidad");
			int xObjeto = intAlJSONn(datosObjeto, "x");
			int yObjeto = intAlJSONn(datosObjeto, "y");
			
			Point posicionObjeto = new Point(xObjeto, yObjeto);
			Objekt objeto = Objektregistril.objektjn(idObjeto);
			//Objektar objetoUnico = new Objektar(posicionObjeto, objeto, 1);
			//objetosMapa.add(objetoUnico);
		}
		
		//OBTENER ENEMIGOS
		vivazhar = new ArrayList<>();
		JSONArray coleccionEnemigos = JSONArrayn(globalJSON.get("enemigos").toString());
		for (int i = 0; i < coleccionEnemigos.size(); i++) {
			JSONObject datosEnemigo = JSONObjektn(coleccionEnemigos.get(i).toString());
			
			int idEnemigo = intAlJSONn(datosEnemigo, "id");
			int xEnemigo = intAlJSONn(datosEnemigo, "x");
			int yEnemigo = intAlJSONn(datosEnemigo, "y");
			
			Point posicionEnemigo = new Point(xEnemigo, yEnemigo);
			Vivazh enemigo = (Vivazh) Estazhregistril.estazhjn(idEnemigo);
			enemigo.setX(xEnemigo);
			enemigo.setY(yEnemigo);
			
			vivazhar.add(enemigo);
		}
		
		gxisdatigitArejKolici = new ArrayList<>();
	}
	
	public void gxisdatig() {
		gxisdatigArejKolicin();
		gxisdatigObjektkolektad();
		
		gxisdatigVivazhjn();
		
	}
	
	private void gxisdatigArejKolicin() {
		if (!gxisdatigitArejKolici.isEmpty()) {
			gxisdatigitArejKolici.clear();
		}
		
		for (int i = 0; i < arejKolici.size(); i++) {
			Rectangle nunRectangle = arejKolici.get(i);
			
			gxisdatigitArejKolici.add(new Rectangle((int) Kvantperant.koordenadXalPosici(nunRectangle.x),
					(int) Kvantperant.koordenadYalPosici(nunRectangle.y), nunRectangle.width, nunRectangle.height));
		}
	}
	
	private void gxisdatigObjektkolektad() {
/*		if (!objetosMapa.isEmpty()) {
            final Rectangle areaJugador = new Rectangle(ElementosPrincipales.jugador.obtenerPosicionXInt(),
                    ElementosPrincipales.jugador.obtenerPosicionYInt(), Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);

            for (int i = 0; i < objetosMapa.size(); i++) {
                final ObjetoUnicoTiled objetoActual = objetosMapa.get(i);

                final Rectangle posicionObjetoActual = new Rectangle(
                        objetoActual.obtenerPosicion().x,
                        objetoActual.obtenerPosicion().y, Constantes.LADO_SPRITE,
                        Constantes.LADO_SPRITE);

                if (areaJugador.intersects(posicionObjetoActual) && GestorControles.teclado.recogiendo) {
                    ElementosPrincipales.inventario.recogerObjetos(objetoActual);
                    objetosMapa.remove(i);
                }
            }
        }*/
	}
	
	private void gxisdatigVivazhjn() {
		if (!vivazhar.isEmpty()) {
			for (Vivazh vivazh:vivazhar) {
				vivazh.setVenontNodn(d.findVenontNodnnPorMalamikj(vivazh));
				vivazh.gxisdatig();
			}	
			
			Point koincidatPunkt = d.koordinatjDeKoincidatNodDeLudantn((int)QefObjektj.ludant.xn(), (int)
					QefObjektj.ludant.yn());
			d.rekomencKajTask(koincidatPunkt);
		}	
		
	}
	
	public void desegn() {
		for (int i = 0; i < spritetavolj.size(); i++) {
			int[] spritesCapa = spritetavolj.get(i).obtenerArraySprites();
			
			for (int y = 0; y < tileeMapalt; y++) {
				for (int x = 0; x < tileeMaplargx; x++) {
					int idSpriteActual = spritesCapa[x + y * tileeMaplargx];
					if (idSpriteActual != -1) {
						int punktX = (int) Kvantperant.koordenadXalPosici(x * Konstantj.SPRITEFLANK);
						int punktY = (int) Kvantperant.koordenadYalPosici(y * Konstantj.SPRITEFLANK);
						
						DebugDesegn.desegnBildn(paletrsprite[idSpriteActual], punktX, punktY);
					}
				}
			}
		}
		for (int i = 0; i < objektarj.size(); i++) {
			Objektar nunObjektar = objektarj.get(i);
			
			int punktX = (int) Kvantperant.koordenadXalPosici(nunObjektar.posicin().x);
			int punktY = (int) Kvantperant.koordenadYalPosici(nunObjektar.posicin().y);
			for(int j = 0; j < nunObjektar.objektj().length; j++)
			DebugDesegn.desegnBildn(nunObjektar.objektj()[j].spriten(),
					punktX, punktY);
		}
		
		for (int i = 0; i < vivazhar.size(); i++) {
			vivazhar.get(i).desegn();
		}
	}
	
	private JSONObject JSONObjektn(final String codigoJSON) {
		JSONParser lector = new JSONParser();
		JSONObject JSONObjekt = null;
		
		try {
			JSONObjekt = (JSONObject) lector.parse(codigoJSON);
		} catch(ParseException e) {
			System.out.println("Posicio: " + e.getPosition());
			System.out.println(e);
		}
		
		return JSONObjekt;
	}
	
	private JSONArray JSONArrayn(final String codigoJSON) {
		JSONParser lector = new JSONParser();
		JSONArray arrayJSON = null;
		
		try {
			arrayJSON = (JSONArray) lector.parse(codigoJSON);
		} catch(ParseException e) {
			System.out.println("Posicio: " + e.getPosition());
			System.out.println(e);
		}
		
		return arrayJSON;
	}
	
	private int intAlJSONn(final JSONObject objektJSON, final String clave) {
		return Integer.parseInt(objektJSON.get(clave).toString());
	}
	
	public Rectangle margxen(final int x, final int y) {
        int posiciX = (Konstantj.duonLudLargx - x + QefObjektj.ludant.largxVivazhn()) + Konstantj.SPRITELARGX;
        int posiciY = (Konstantj.duonLudAlt - y + QefObjektj.ludant.altVivazhn()) + Konstantj.SPRITEALT;

        int largx = (this.tileeMaplargx*Konstantj.SPRITELARGX - (Konstantj.SPRITELARGX * 3)) -
        		QefObjektj.ludant.largxVivazhn()*2;
        int alt = (this.tileeMapalt * Konstantj.SPRITEALT - (Konstantj.SPRITEALT*3)) -
        		QefObjektj.ludant.altVivazhn()*2;
        
        return new Rectangle(posiciX, posiciY, largx, alt);
	}
}