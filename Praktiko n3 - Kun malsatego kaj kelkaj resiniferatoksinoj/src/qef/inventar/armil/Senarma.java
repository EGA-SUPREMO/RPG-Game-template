package qef.inventar.armil;

import java.awt.Rectangle;
import java.util.ArrayList;

import qef.Konstantj;
import qef.estazhj.vivazhj.Vivazh;

public class Senarma extends Armil{
	
	public Senarma(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, plejatako, mlplejatako, false, false, 0, Konstantj.ITENER_SONJ_LUDANT + "pom.wav");
	}
	
	@Override
	public ArrayList<Rectangle> atingec(final Vivazh vivazh) {
		return null;
	}
	
}