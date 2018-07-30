package qef.inventar;

import java.awt.Point;

public class Objektar {
	
	private Point posici;
	private Objekt[] objektj;
	
	public Objektar(final Point posicio, final int[] objektoj, final int[] kvantj) {
		posici = posicio;
		objektj = new Objekt[objektoj.length];
		
		for(int i = 0; i < objektj.length; i++) {
			objektj[i] = Objektregistril.objektj[objektoj[i]];
			objektj[i].pliigKvantn(kvantj[i]);
		}
		
	}
	
}
