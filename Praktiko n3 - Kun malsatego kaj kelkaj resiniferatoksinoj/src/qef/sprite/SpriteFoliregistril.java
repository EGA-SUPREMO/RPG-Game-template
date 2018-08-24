package qef.sprite;

import java.awt.Transparency;

import qef.Konstantj;

public abstract class SpriteFoliregistril {

	public static SpriteFoli[] zombi = new SpriteFoli[60];

	public static SpriteFoli KreZombiSpriteFolin(final int id) {
		zombi[id] = new SpriteFoli(Konstantj.ITENER_ZOMBI + id + ".png", 32, Transparency.TRANSLUCENT);
		return zombi[id];
	}
	public static void ZombiSpriteFolin(final int id) {
		zombi[id] = null;
	}
	
}