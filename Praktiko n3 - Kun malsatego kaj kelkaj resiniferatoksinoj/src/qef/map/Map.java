package qef.map;

import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
//import java.util.Random;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;
import qef.sprite.SpriteFoli;

public class Map {
	
//	private Random r = new Random();
	private final int largx, alt;
	private final int xLudant;
	private final int yLudant;
	private final boolean[] kolicij;
	public ArrayList<Rectangle> arejKolici;
	private final Rectangle arejVenontMap;
	private final int posiciXVenontMap;
	private final int posiciYVenontMap;
	private final int venontMap;
	private BufferedImage[] map;
	private BufferedImage[] spritear;
	
	public Map(final int itener) {
		
		arejKolici = new ArrayList<>();
		
		final String[] enhav = YargxilAzhj.yargxTextn(Konstantj.ITENER_MAP + itener + Konstantj.SUFIX_MAP).split("@");
		
		largx = Integer.parseInt(enhav[0]);
		alt = Integer.parseInt(enhav[1]);
		spritear = elSprites(enhav[2].split(","), enhav[3].split("\\."));
		kolicij = elKolicijn(enhav[4]);
		map = elMapn(enhav[5].toCharArray());
		
		final String[] komencPosici = enhav[6].split("_");
		
		xLudant = Integer.parseInt(komencPosici[0]);
		yLudant = Integer.parseInt(komencPosici[1]);
		
		final String[] venontMapDatumj = enhav[7].split("_");

		posiciXVenontMap = Integer.parseInt(venontMapDatumj[0]);
		posiciYVenontMap = Integer.parseInt(venontMapDatumj[1]);
		arejVenontMap = new Rectangle(posiciXVenontMap, posiciYVenontMap, Konstantj.SPRITELARGX, Konstantj.SPRITEALT);
		
		venontMap = Integer.parseInt(venontMapDatumj[2]);
		
	}
	
	public void gxisdatig() {
		gxisdatigArejKolicin();
		gxisdatigArejn();
	}
	
	private void gxisdatigArejKolicin() {
		if(!arejKolici.isEmpty())
			arejKolici.clear();
		
		for(int y = 0; y < alt; y++)
			for(int x = 0; x < largx; x++)
				if(kolicij[x + y * largx])
					arejKolici.add(new Rectangle((int) (Kvantperant.koordenadXalPosici(x * Konstantj.SPRITELARGX)), (int)
							(Kvantperant.koordenadYalPosici(y * Konstantj.SPRITEALT)), Konstantj.SPRITELARGX, Konstantj.SPRITEALT));
		
	}
	private void gxisdatigArejn() {
		
		arejVenontMap.x = (int) (Kvantperant.koordenadXalPosici(posiciXVenontMap));
		arejVenontMap.y = (int) (Kvantperant.koordenadYalPosici(posiciYVenontMap));
		
	}
	
	public void desegn() {
		
		for(int y = 0; y < alt; y++)
			for(int x = 0; x < largx; x++)
				DebugDesegn.desegnBildn(map[x + y * largx], (int) (Kvantperant.koordenadXalPosici(x * Konstantj.SPRITELARGX)), (int)
						(Kvantperant.koordenadYalPosici(y * Konstantj.SPRITEALT)));
		
	}
	
	
	private BufferedImage[] elMapn(final char[] charMap) {
		
		BufferedImage[] sprites = new BufferedImage[charMap.length];
		
		for (int i = 0; i < charMap.length; i++)
			switch (charMap[i]) {
				case '0':
					/*switch(r.nextInt(80)) {
						case 0:
							sprites[i] = spritear[30];
							continue;
						case 1:
							sprites[i] = spritear[31];
							continue;
						case 2:
							sprites[i] = spritear[33];
							continue;
						case 5:
							sprites[i] = spritear[34];
							continue;
						case 6:
							sprites[i] = spritear[35];
							continue;
						case 7:
							sprites[i] = spritear[31];
							continue;
						default:
							sprites[i] = spritear[0];
							continue;
					}*/
					sprites[i] = spritear[0];
					continue;
				case '1':
					sprites[i] = spritear[1];
					continue;
				case '2':
					sprites[i] = spritear[2];
					continue;
				case '3':
					sprites[i] = spritear[3];
					continue;
				case '4':
					sprites[i] = spritear[4];
					continue;
				case '5':
					sprites[i] = spritear[5];
					continue;
				case '6':
					sprites[i] = spritear[6];
					continue;
				case '7':
					sprites[i] = spritear[7];
					continue;
				case '8':
					sprites[i] = spritear[8];
					continue;
				case '9':
					sprites[i] = spritear[9];
					continue;
				case 'a':
					sprites[i] = spritear[10];
					continue;
				case 'b':
					sprites[i] = spritear[11];
					continue;
				case 'c':
					sprites[i] = spritear[12];
					continue;
				case 'd':
					sprites[i] = spritear[13];
					continue;
				case 'e':
					sprites[i] = spritear[14];
					continue;
				case 'f':
					sprites[i] = spritear[15];
					continue;
				case 'g':
					sprites[i] = spritear[16];
					continue;
				case 'h':
					sprites[i] = spritear[17];
					continue;
				case 'i':
					sprites[i] = spritear[18];
					continue;
				case 'j':
					sprites[i] = spritear[19];
					continue;
				case 'k':
					sprites[i] = spritear[20];
					continue;
				case 'l':
					sprites[i] = spritear[21];
					continue;
				case 'm':
					sprites[i] = spritear[22];
					continue;
				case 'n':
					sprites[i] = spritear[23];
					continue;
				case 'o':
					sprites[i] = spritear[24];
					continue;
				case 'p':
					sprites[i] = spritear[25];
					continue;
				case 'q':
					sprites[i] = spritear[26];
					continue;
				case 'r':
					sprites[i] = spritear[27];
					continue;
				case 's':
					sprites[i] = spritear[28];
					continue;
				case 't':
					sprites[i] = spritear[29];
					continue;
				case 'u':
					sprites[i] = spritear[30];
					continue;
				default:
					sprites[i] = spritear[0];
			}
		
		return sprites;
	}
	
	private BufferedImage[] elSprites(final String[] foli, final String[] sprite) {
		
		final BufferedImage[] sprites = new BufferedImage[sprite.length];
		final SpriteFoli[] folij = new SpriteFoli[foli.length];
		
		for(int i = 0; i < foli.length;i++)
			folij[i] = new SpriteFoli("/blocks/map_" + foli[i] + ".png", 32, Transparency.OPAQUE);
		
		for(int i = 0; i < sprite.length; i++) {
			
			String[] tempSprite = sprite[i].split("_");
			
			sprites[i] = folij[Integer.parseInt(tempSprite[0])].spritejn(Integer.parseInt(tempSprite[1]),
					Integer.parseInt(tempSprite[2]));
			
		}
		
		return sprites;
	}
	
	private boolean[] elKolicijn(final String enhav) {
		
		final boolean[] kolicij = new boolean[enhav.length()];
		
		for(int i = 0; i < enhav.length();i++)
			if(enhav.charAt(i) == '0')
				kolicij[i] = false;
			else
				kolicij[i] = true;
		
		return kolicij;
	}
	
/*	public ArrayList<Rectangle> arejKolicin() {
		return arejKolici;
	}*/
	
	public BufferedImage[] spritesn() {
		return spritear;
	}
	
	public Rectangle margxen(final int x, final int y) {
        int posicioX = (Konstantj.duonLudLargx - x + QefObjektj.ludant.largxVivazhn()) + Konstantj.SPRITELARGX;
        int posicioY = (Konstantj.duonLudAlt - y + QefObjektj.ludant.altVivazhn()) + Konstantj.SPRITEALT;

        int largx = (this.largx * Konstantj.SPRITELARGX - (Konstantj.SPRITELARGX * 3)) - QefObjektj.ludant.largxVivazhn() * 2;
        int alt = (this.alt * Konstantj.SPRITEALT - (Konstantj.SPRITEALT * 3)) - QefObjektj.ludant.altVivazhn() * 2;

        return new Rectangle(posicioX, posicioY, largx, alt);
	}
	
	public int xLudantn() {
		return xLudant;
	}
	public int yLudantn() {
		return yLudant;
	}
	public Rectangle arejVenontMapn() {
		return arejVenontMap;
	}
	public int venontMapn() {
		return venontMap;
	}
	
	
}