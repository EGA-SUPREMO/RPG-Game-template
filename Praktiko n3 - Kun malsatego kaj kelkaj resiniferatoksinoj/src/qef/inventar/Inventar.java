package qef.inventar;

import java.util.ArrayList;

import qef.inventar.armil.Armil;
import qef.inventar.konsumeblezh.Konsumeblezh;

public class Inventar {
	
	public final ArrayList<Objekt> objektj;
	
	public Inventar() {
		objektj = new ArrayList<>();
		objektj.add(Objektregistril.objektjn(500));
	}
	
	public boolean pliigObjekt(final Objekt objekt, final int kvant) {
		boolean qpliigitObjekt = false;
		
		for(Objekt o: objektj)
			if(o.idn()==objekt.idn()) {
				o.pliigKvantn(kvant);
				qpliigitObjekt = true;
				break;
			}
		
		return qpliigitObjekt;
	}
	
	public void kolektObjekt(final Objektar objektar) {
		for(Objekt nun: objektar.objektj()) {
			if(estasObjekt(nun))
				pliigObjekt(nun, nun.kvantn());
			else
				objektj.add(nun);
		}
	}
	private boolean estasObjekt(final Objekt obj) {
		boolean qest = false;
		
		for(Objekt nun:objektj) {
			if(qest = nun.idn()==obj.idn())
				break;
		}
		return qest;
	}
	public Objekt objektn(final int id) {
		for(Objekt nun: objektj)
			if(nun.idn()==id)
				return nun;
		return null;
	}
	public ArrayList<Objekt> armiljn() {
		final ArrayList<Objekt> armilj = new ArrayList<>();
		
		for(Objekt nun: objektj)
			if(nun instanceof Armil)
				armilj.add(nun);
		
		return armilj;
	}
	public ArrayList<Objekt> konsumeblazhjn() {
		final ArrayList<Objekt> konsumeblazhj = new ArrayList<>();
		
		for(Objekt nun: objektj)
			if(nun instanceof Konsumeblezh)
				konsumeblazhj.add(nun);
		
		return konsumeblazhj;
	}
	
}