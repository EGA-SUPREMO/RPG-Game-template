package qef.estazhj.vivazhj;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.sprite.SpriteFoliregistril;

public class Zombi extends Vivazh {
	public Zombi(final float rapidec, final int largxVivazh, final int altVivazh,
			final int viv, Rectangle[] limj, final int sprite) {
		super(0, rapidec, largxVivazh, altVivazh, viv, limj, SpriteFoliregistril.KreZombiSpriteFolin(sprite));
	}
	
	public Zombi(final int sprite) {
		super(0, 1, SpriteFoliregistril.KreZombiSpriteFolin(sprite));
		LIMJ[0] = new Rectangle((int)x, (int) y, largxVivazh, altVivazh);
	}
	@Override
	public void desegn() {
		final int posiciX = (int) Kvantperant.koordenadXalPosici(x);
		final int posiciY = (int) Kvantperant.koordenadYalPosici(y);
		DebugDesegn.desegnBildn(bildj[nunBild], posiciX, posiciY);
		DebugDesegn.desegnRectangle(posiciX, posiciY - 5, largxVivazh * viv/plejviv, 3, Color.RED);
		DebugDesegn.desegnString(String.format("%.4f", Kvantperant.kakulDistancn((int) x +
				QefObjektj.ludant.largxVivazh/2, (int) y + QefObjektj.ludant.altVivazh/2, (int) QefObjektj.ludant.x,
				(int) QefObjektj.ludant.y)/Konstantj.SPRITEFLANK), (int) posiciX, (int) posiciY - 7);
	}

	@Override
	public void setX(final int x) {
		super.setX(x);
		LIMJ[0].x = x;
	}
	@Override
	public void setY(final int y) {
		super.setY(y);
		LIMJ[0].y = y;
	}
	
}