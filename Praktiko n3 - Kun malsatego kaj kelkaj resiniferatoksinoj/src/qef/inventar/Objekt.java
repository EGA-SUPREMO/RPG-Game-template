package qef.inventar;

import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.sprite.SpriteFoli;

public class Objekt {
	
	public static SpriteFoli ObjektSpriteFoli = new SpriteFoli(Konstantj.ITENER_OBJEKTJ + 0 + ".png",
			Konstantj.SPRITEFLANK, Transparency.OPAQUE);
	
	private int id;
	private String priskrib;
	private String nom;
	
	private BufferedImage sprite;
	
	private int kvant;
	private int plejkvant;
	
	public Objekt(final int id, final String nomo, final String priskribo) {
		this.id = id;
		nom = nomo;
		priskrib = priskribo;
		
		sprite = ObjektSpriteFoli.spritejn(id);
		
		kvant = 0;
		plejkvant = 128;
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
	public BufferedImage spriten() {
		return sprite;
	}
	public int kvantn() {
		return kvant;
	}
	
	public int idn() {
		return id;
	}
	
}