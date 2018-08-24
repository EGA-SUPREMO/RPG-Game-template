package qef.inventar.armil;

import java.awt.Rectangle;
import java.util.ArrayList;

import qef.estazhj.vivazhj.Vivazh;

public class Senarma extends Armil{
	
	public Senarma(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, plejatako, mlplejatako);
	}
	
	public Senarma(final int id, final String nomo, final String priskribo, final int kvanto, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, kvanto, plejatako, mlplejatako);
	}
	
	@Override
	public ArrayList<Rectangle> atingec(final Vivazh vivazh) {
		return null;
	}
	
}