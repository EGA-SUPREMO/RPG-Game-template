package qef.inventar;

import java.awt.Point;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;

public class Objektar {
	
	private static BufferedImage sprite = YargxilAzhj.yargxBildn(Konstantj.ITENER_OBJEKT_OBJEKTAR, Transparency.TRANSLUCENT);
	private Point posici;
	private Objekt[] objektj;
	
	public Objektar(final Point posicio, final int[] objektoj, final int[] kvantj) {
		posici = posicio;
		objektj = new Objekt[objektoj.length];
		
		for(int i = 0; i < objektj.length; i++) {
			objektj[i] = Objektregistril.objektjn(objektoj[i]);
			objektj[i].pliigKvantn(kvantj[i]);
		}
		
	}

	public void desegn() {
		DebugDesegn.desegnBildn(sprite, (int) Kvantperant.koordenadXalekranPosicin(posici.x*Konstantj.SPRITEFLANK),
				(int) Kvantperant.koordenadYalekranPosicin(posici.y*Konstantj.SPRITEFLANK));
	}
	
	public Point posicin() {
		return posici;
	}
	public Objekt[] objektj() {
		return objektj;
	}
}