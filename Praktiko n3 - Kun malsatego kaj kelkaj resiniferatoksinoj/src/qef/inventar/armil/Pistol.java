package qef.inventar.armil;

import java.awt.Rectangle;
import java.util.ArrayList;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.Vivazh;

public class Pistol extends Armil {
	
	public Pistol(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, plejatako, mlplejatako);
	}
	
	public Pistol(final int id, final String nomo, final String priskribo, final int kvanto, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, kvanto, plejatako, mlplejatako);
	}
	
	//dekstre = 1; maldekstre = 6; sub = 2; supre = 4; supre-dekstre = 5; supre-maldekstre = 8; sube-dekstre = 7
	@Override
	public ArrayList<Rectangle> atingec(final Vivazh vivazh) {
		final ArrayList<Rectangle> atingec = new ArrayList<>();

		final Rectangle atingec1 = new Rectangle();
		final int spritesAtingec = 10;
		if(vivazh instanceof Ludant) {
			if (QefObjektj.ludant.direktn() == 2 || QefObjektj.ludant.direktn() == 4) {
				atingec1.width = 1;
				atingec1.height = spritesAtingec * Konstantj.SPRITEFLANK;
			
				atingec1.x = Konstantj.largxCentr;
				if (QefObjektj.ludant.direktn() == 2) 
					atingec1.y = Konstantj.altCentr - 9;
				else 
					atingec1.y = Konstantj.altCentr - 9 - atingec1.height;
			} else {
				atingec1.width = spritesAtingec * Konstantj.SPRITEFLANK;
				atingec1.height = 1;
				
				atingec1.y = Konstantj.altCentr - 3;
				
				if (QefObjektj.ludant.direktn() == 6)
					atingec1.x = Konstantj.largxCentr - atingec1.width;
				else
					atingec1.x = Konstantj.largxCentr;
			}
		}
		atingec.add(atingec1);

		return atingec;
	}

	
}
