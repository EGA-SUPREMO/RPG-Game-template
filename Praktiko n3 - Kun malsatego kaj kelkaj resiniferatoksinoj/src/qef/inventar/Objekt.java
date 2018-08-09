package qef.inventar;

import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Objekt {
	
	protected int id;
	protected String priskrib;
	protected String nom;
	
	protected int kvant;
	protected int plejkvant;

	protected Point menuposici;
	protected Point floatMenuposici;
	
	public Objekt(final int id, final String nomo, final String priskribo) {
		this.id = id;
		nom = nomo;
		priskrib = priskribo;
		
		kvant = 0;
		plejkvant = 128;

		menuposici = new Point(0, 0);
		floatMenuposici = new Point(0, 0);
	}
	public Objekt(final int id, final String nomo, final String priskribo, final int kvanto) {
		this(id, nomo, priskribo);
		if(kvanto<=plejkvant)
			kvant = kvanto;

	}

	public boolean pliigKvantn(final int pliig) {
		boolean qpliigita = false;
		int finKvant = pliig + kvant;
		
		if(finKvant <= plejkvant) {
			kvant = finKvant;
			qpliigita = true;
		}
		
		return qpliigita;
	}
	
	public boolean mlpliigKvantn(final int mlpliig) {
		boolean qmlpliigita = false;
		int finKvant = mlpliig - kvant;
		
		if(finKvant >= 0) {
			kvant = finKvant;
			qmlpliigita = true;
		}
		
		return qmlpliigita;
	}
	public abstract BufferedImage spriten();
	public int kvantn() {
		return kvant;
	}
	
	public int idn() {
		return id;
	}
	public Point menuposicin() {
		return menuposici;
	}
	public Point floatMenuposicin() {
		return floatMenuposici;
	}
	public void setMenuposicin(final Point pos) {
		menuposici = pos;
	}
	public void setFloatMenuposicin(final Point pos) {
		floatMenuposici = pos;
	}
	
}