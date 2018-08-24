package qef.inventar.armil;

import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import qef.Konstantj;
import qef.estazhj.vivazhj.Vivazh;
import qef.inventar.Objekt;
import qef.sprite.SpriteFoli;

public abstract class Armil extends Objekt {
	
	public static SpriteFoli ArmilSpriteFoli = new SpriteFoli(Konstantj.ITENER_OBJEKT_ARMIL + 0 + ".png",
			Konstantj.SPRITEFLANK, Transparency.TRANSLUCENT);
	
	protected int plejatak;
	protected int mlplejatak;
	
	public Armil(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo);

		plejatak = plejatako;
		mlplejatak = mlplejatako;
		
	}
	
	public Armil(final int id, final String nomo, final String priskribo, final int kvanto, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, kvanto);
		
		plejatak = plejatako;
		mlplejatak = mlplejatako;
		
	}
	
	@Override
	public BufferedImage spriten() {
		return ArmilSpriteFoli.spritejn(Konstantj.KVANT_KONSUMEBL_OBJEKT - id);
	}

	public abstract ArrayList<Rectangle> atingec(Vivazh vivazh);
	
}
