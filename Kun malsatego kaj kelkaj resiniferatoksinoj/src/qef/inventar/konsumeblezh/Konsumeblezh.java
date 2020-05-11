package qef.inventar.konsumeblezh;

import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.inventar.Objekt;
import qef.sprite.SpriteFoli;

public class Konsumeblezh extends Objekt {
	
	public static SpriteFoli ObjektSpriteFoli = new SpriteFoli(Konstantj.ITENER_OBJEKTJ + 0 + ".png",
			Konstantj.SPRITEFLANK, Transparency.TRANSLUCENT);
	
	public Konsumeblezh(int id, String nomo, String priskribo) {
		super(id, nomo, priskribo);
	}
	
	public Konsumeblezh(int id, String nomo, String priskribo, int kvanto) {
		super(id, nomo, priskribo, kvanto);
	}

	@Override
	public BufferedImage spriten() {
		return ObjektSpriteFoli.spritejn(id);
	}
	
}
