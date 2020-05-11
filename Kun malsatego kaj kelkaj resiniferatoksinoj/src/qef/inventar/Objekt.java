package qef.inventar;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Objekt {
	
	protected int id;
	protected String priskrib;
	protected String nom;
	
	protected int kvant;
	protected int plejkvant;

	protected Rectangle menuposici;
	protected Rectangle floatMenuposici;
	
	public Objekt(final int id, final String nomo, final String priskribo) {
		this.id = id;
		nom = nomo;
		priskrib = priskribo;
		
		kvant = 0;
		plejkvant = 128;

		menuposici = new Rectangle(0, 0, 32, 32);
		floatMenuposici = new Rectangle(0, 0, 32, 32);
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
	public Rectangle menuposicin() {
		return menuposici;
	}
	public Rectangle floatMenuposicin() {
		return floatMenuposici;
	}
	public void setMenuposicin(final int x, final int y) {
		menuposici.x = x;
		menuposici.y = y;
	}
	public void setFloatMenuposicin(final int x, final int y) {
		floatMenuposici.x = x;
		floatMenuposici.y = y;
	}
	
}