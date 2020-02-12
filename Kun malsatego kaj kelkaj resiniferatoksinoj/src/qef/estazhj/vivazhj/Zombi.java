package qef.estazhj.vivazhj;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.sprite.SpriteFoliregistril;

public class Zombi extends Vivazh {
	
	public Zombi(final int sprite, final String itenerSon) {
		super(0, 1, SpriteFoliregistril.KreZombiSpriteFolin(sprite), itenerSon);
		LIMJ[0] = new Rectangle((int)x, (int) y, largxVivazh, altVivazh);
		rapidec = 0.5;
	}
	@Override
	public void desegn() {
		if(viv>0) {
			final int posiciX = (int) Kvantperant.koordenadXalekranPosicin(x);
			final int posiciY = (int) Kvantperant.koordenadYalekranPosicin(y);
			DebugDesegn.desegnBildn(bildj[nunBild], posiciX, posiciY);
			DebugDesegn.desegnRectangle(posiciX, posiciY - 5, largxVivazh * viv/plejviv, 3, Color.RED);
			DebugDesegn.desegnString(String.format("%.4f", Kvantperant.kakulDistancn((int) x +
					QefObjektj.ludant.largxVivazh/2, (int) y + QefObjektj.ludant.altVivazh/2, (int)
					QefObjektj.ludant.x, (int) QefObjektj.ludant.y)/Konstantj.SPRITEFLANK), (int) posiciX, (int)
					posiciY - 7);
		}
	}
	
	@Override
	public void gxisdatig() {
		if (venontNod == null) {
			return;
		}
		for (Vivazh vivazh : QefObjektj.map.vivazhar) {
			if (vivazh.nunposiciare().equals(nunposiciare()))
				continue;
			if (vivazh.nunposiciare().intersects(venontNod.aren()))
				return;
		}
		
		final int venontNodX = venontNod.posicin().x * Konstantj.SPRITEFLANK;
		final int venontNodY = venontNod.posicin().y * Konstantj.SPRITEFLANK;
		
		if (x < venontNodX)
			x += rapidec;
		if (x > venontNodX)
			x -= rapidec;
		
		if (y < venontNodY)
			y += rapidec;
		if (y > venontNodY)
			y -= rapidec;

		this.LIMJ[0].x = (int) x;
		this.LIMJ[0].y = (int) y;
		
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