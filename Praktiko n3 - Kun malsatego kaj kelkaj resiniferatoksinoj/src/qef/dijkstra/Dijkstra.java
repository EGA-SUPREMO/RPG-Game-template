package qef.dijkstra;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import qef.Konstantj;
import qef.estazhj.vivazhj.Vivazh;

public class Dijkstra {

	private int tileeMaplargx;
	private int tileeMapalt;
	
	private ArrayList<Nod> mapnodj;
	private ArrayList<Nod> netaskitj;
	private ArrayList<Nod> taskitj;
	
	private boolean constructor = true;
	private final double DIAGONAL_DISTANC = 1.424;
	
	public Dijkstra(final Point centr, final int tileeMaplargx, final int tileeMapalt,
			final ArrayList<Rectangle> arejKolici) {
		
		this.tileeMaplargx = tileeMaplargx;
		this.tileeMapalt = tileeMapalt;
		mapnodj = new ArrayList<>();
		
		for (int y = 0; y < tileeMapalt; y++) {
			for (int x = 0; x < tileeMaplargx; x++) {
				final Rectangle nodlok = new Rectangle(x * Konstantj.SPRITEFLANK, y * Konstantj.SPRITEFLANK,
						Konstantj.SPRITEFLANK, Konstantj.SPRITEFLANK);
				
				boolean qtransenebl = true;
				for (Rectangle are : arejKolici) {
					if (nodlok.intersects(are)) {
						qtransenebl = false;
						break;
					}
				}
				
				if (!qtransenebl) {
					continue;
				}
				
				mapnodj.add(new Nod(new Point(x,y), Double.MAX_VALUE));
			}
		}
		netaskitj = new ArrayList<>(mapnodj);
		
		rekomencKajTask(centr);
		constructor = false;
	}
	
	public Point koordinatjDeKoincidatNodDeLudantn(final int Xludantpunkt, final int Yludantpunkt) {
		Rectangle ekzaktRektangul = new Rectangle(Xludantpunkt / Konstantj.SPRITEFLANK,
				Yludantpunkt / Konstantj.SPRITEFLANK, 1, 1);
		
		Point ekzaktPunkt = null;
		
		for (Nod nod : mapnodj) {
			if (nod.aren().intersects(ekzaktRektangul)) {
				ekzaktPunkt = new Point(ekzaktRektangul.x, ekzaktRektangul.y);
				return ekzaktPunkt;
			}
		}
		
		return ekzaktPunkt;
	}
	//TODO aqua-s method
	private ArrayList<Nod> clonarNodosMapaANodosPendientes() {
		ArrayList<Nod> nodosClonados = new ArrayList<>();
		for (Nod nodo : mapnodj) {
			Point posicion = nodo.posicin();
			double distancia = nodo.distancn();
			Nod nodoClonado = new Nod(posicion, distancia);
			nodosClonados.add(nodoClonado);
		}
			
		return nodosClonados;
	}
	
	public void rekomencKajTask(final Point kalkulcentr) {
		if (!constructor) {
			if (taskitj.size() == 0) {
				clonarNodosMapaANodosPendientes();
			} else {
				netaskitj = new ArrayList<>(taskitj);
				for (Nod nod : netaskitj) {
					nod.setDistancn(Double.MAX_VALUE);
				}
			}
		}
		
		definKalkulCentrnEnNetaskitj(kalkulcentr);
		taskitj = new ArrayList<>();
		taskGlobHewristikn();
	}
	
	private void definKalkulCentrnEnNetaskitj(final Point kalkulcentr) {
		for (Nod nod : netaskitj) {
			if (nod.posicin().equals(kalkulcentr)) {
				nod.setDistancn(0.0);
			}
		}
	}
	
	private void taskGlobHewristikn() {
		while (!netaskitj.isEmpty()) {
			int yangxj = 0;
			
			for (Iterator<Nod> iterator = netaskitj.iterator(); iterator.hasNext();) {
				Nod nod = iterator.next();
				
				if (nod.distancn() == Double.MAX_VALUE) {
					continue;
				} else {
					taskApudHewristikn(nod);
					taskitj.add(nod);
					iterator.remove();
					yangxj++;
				}
			}
			
			if(yangxj == 0) {
				break;
			}
		}
	}
	
	private void taskApudHewristikn(final Nod nod) {
		
		for (int y = nod.posicin().y - 1; y < nod.posicin().y + 2; y++) {
			for (int x = nod.posicin().x - 1; x < nod.posicin().x + 2; x++) {
				if (x <= -1 || y <= -1 || x >= tileeMaplargx || y >= tileeMapalt) {
					continue;
				}
				if (nod.posicin().x == x && nod.posicin().y == y) {
					continue;
				}
				
				int indexNod = nodindexnPerNetaskitposicij(new Point(x, y));
				if (indexNod == -1) {
					continue;
				}
				
				//solo cambiamos la distancia si es transitable y si no ha sido cambiada
				if (netaskitj.get(indexNod).distancn() == Double.MAX_VALUE - 1) {
					
					//distancia recta vs diagonal
					double distanc;
					if (nod.posicin().x != x && nod.posicin().y != y) {
						distanc = DIAGONAL_DISTANC;
					} else {
						distanc = 1;
					}
					
					netaskitj.get(indexNod).setDistancn(nod.distancn() + distanc);
				}
			}
		}
	}
	
	private ArrayList<Nod> apudNodjn(final Nod nod) {
		ArrayList<Nod> apudNodj = new ArrayList<>();
		
		for (int y = nod.posicin().y - 1; y < nod.posicin().y + 2; y++) {
			for (int x = nod.posicin().x - 1; x < nod.posicin().x + 2; x++) {
				if (x <= -1 || y <= -1 || x >= tileeMaplargx || y >= tileeMapalt) {
					continue;
				}
				
				if (nod.posicin().x == x && nod.posicin().y == y) {
					continue;
				}
				
				int indexNod = nodindexnPerTaskitposicij(new Point(x, y));
				if (indexNod == -1) {
					continue;
				}
				apudNodj.add(taskitj.get(indexNod));
			}
		}
		
		return apudNodj;
	}
	
	public Nod findVenontNodnnPorMalamikj(final Vivazh vivazh) {
		ArrayList<Nod> tuyantNodj = new ArrayList<>();
		
		Nod venontNod = null;
		
		for (Nod nod : taskitj) {
			if (vivazh.nunposiciare().intersects(nod.pixeleAre())) {
				tuyantNodj.add(nod);
			}
		}
		
		if (tuyantNodj.size() == 1) {
			Nod nodoBase = tuyantNodj.get(0);
			tuyantNodj = apudNodjn(nodoBase);
		}
		
		for (int i = 0; i < tuyantNodj.size(); i++) {
			if (i == 0) {
				venontNod = tuyantNodj.get(0);
			} else {
				if (venontNod.distancn() > tuyantNodj.get(i).distancn()) {
					venontNod = tuyantNodj.get(i);
				}
			}
		}
		
		return venontNod;
	}
	
	private int nodindexnPerNetaskitposicij(final Point posici) {
		for (Nod nod : netaskitj) {
			if (nod.posicin().equals(posici)) {
				return netaskitj.indexOf(nod);
			}
		}
		
		return -1;
	}
	
	private int nodindexnPerTaskitposicij(final Point posici) {
		for (Nod nod : taskitj) {
			if (nod.posicin().equals(posici)) {
				return taskitj.indexOf(nod);
			}
		}
		
		return -1;
	}
	
	public ArrayList<Nod> taskitjn() {
		return taskitj;
	}
	
	public ArrayList<Nod> netaskitjn() {
		return netaskitj;
	}
}