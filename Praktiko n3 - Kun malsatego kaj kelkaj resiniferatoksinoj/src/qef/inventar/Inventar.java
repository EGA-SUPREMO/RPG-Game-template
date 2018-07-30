package qef.inventar;

import java.util.ArrayList;

public class Inventar {
	
	public final ArrayList<Objekt> objektj;
	
	public Inventar() {
		objektj = new ArrayList<>();

		objektj.add(Objektregistril.objektj[0]);
		objektj.add(Objektregistril.objektj[1]);
		objektj.add(Objektregistril.objektj[2]);
		objektj.add(Objektregistril.objektj[3]);
		objektj.add(Objektregistril.objektj[4]);
		objektj.add(Objektregistril.objektj[5]);
		objektj.add(Objektregistril.objektj[6]);
		objektj.add(Objektregistril.objektj[7]);
		
	}
	
	public boolean pliigObjektn(final Objekt objekt, final int kvant) {
		boolean qpliigitObjekt = false;
		
		for(Objekt o: objektj)
			if(o.idn()==objekt.idn()) {
				o.pliigKvantn(kvant);
				qpliigitObjekt = true;
				break;
			}
		
		return qpliigitObjekt;
	}
	
}