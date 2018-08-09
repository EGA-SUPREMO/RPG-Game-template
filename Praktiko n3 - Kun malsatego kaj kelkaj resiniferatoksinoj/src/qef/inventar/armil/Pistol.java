package qef.inventar.armil;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Pistol extends Armil {
	
	public Pistol(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, plejatako, mlplejatako);
	}
	
	public Pistol(final int id, final String nomo, final String priskribo, final int kvanto, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, kvanto, plejatako, mlplejatako);
	}
	
	@Override
	public ArrayList<Rectangle> atingec() {
		return null;
	}

	
}
