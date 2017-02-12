package qef.estazhj.vivazhj;

import java.awt.Transparency;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.kontrolj.Kontrolperant;
import qef.map.Map;
import qef.sprite.SpriteFoli;

public class Ludant extends Vivazh {
	
	public Ludant(final Map map) {
		super(map, 0, new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32, Transparency.TRANSLUCENT, 128));
	}
	
	@Override
	public void gxisdatig() {
		yangxMapn();
		yangxResistencn();
		mov();
		anim(movante);
		
	}

	private void mov() {
		
		boolean[] kolicie = {qnekolicie(0), qnekolicie(1), qnekolicie(2), qnekolicie(3), qena()};
		
		if(Kontrolperant.klavar.supr.pulsitan() && kolicie[0]) {
			if(Kontrolperant.klavar.dextr.pulsitan() && kolicie[3]) {
				movante = true;
				direkt = 5;
				yangxRapidec();
				pliX();
				mlpliY();
			}else if(Kontrolperant.klavar.mldextr.pulsitan() && kolicie[2]) {
				movante = true;
				direkt = 8;
				yangxRapidec();
				mlpliX();
				mlpliY();
			}else {
				movante = true;
				direkt = 4;
				yangxRapidec();
				mlpliY();
			}
		}
		if(Kontrolperant.klavar.sub.pulsitan() && kolicie[1]) {
			if(Kontrolperant.klavar.dextr.pulsitan() && kolicie[3]) {
				movante = true;
				direkt = 7;
				yangxRapidec();
				pliX();
				pliY();
			}else if(Kontrolperant.klavar.mldextr.pulsitan() && kolicie[2]) {
				movante = true;
				direkt = 3;
				yangxRapidec();
				mlpliX();
				pliY();
			}else {
				movante = true;
				direkt = 2;
				yangxRapidec();
				pliY();
			}
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !movante && kolicie[2]) {
			movante = true;
			direkt = 6;
			yangxRapidec();
			mlpliX();
		}
		if(Kontrolperant.klavar.dextr.pulsitan() && !movante && kolicie[3]) {
			movante = true;
			direkt = 1;
			yangxRapidec();
			pliX();
			
		}
		
	}
	
	private void yangxResistencn() {
		if(restarigad < Konstantj.plejRestarigad && !Kontrolperant.klavar.kuri)
			restarigad++;
		else if(restarigad == Konstantj.plejRestarigad && resistenc < Konstantj.plejResistenc)
			resistenc++;
	}

	private void yangxRapidec() {
		
		if(Kontrolperant.klavar.kuri && resistenc > 0) {
			rapidec = 2.8f;
			frekvenciAnimaci = 2;
			resistenc--;
			restarigad = 0;
		}else {
			rapidec = 0.7f;
			frekvenciAnimaci = 8;
		}
		
	}

	@Override
	public void desegn() {
		
		DebugDesegn.desegnBildn(bildj[nunBild], Konstantj.largxCentr, Konstantj.altCentr);
//		g.drawImage(bildj[nunBild], Konstantj.largxCentr, Konstantj.altCentr, null);
/*		g.drawRect(LIMJ[0].x, LIMJ[0].y, LIMJ[0].width, LIMJ[0].height);
		g.drawRect(LIMJ[1].x, LIMJ[1].y, LIMJ[1].width, LIMJ[1].height);
		g.drawRect(LIMJ[2].x, LIMJ[2].y, LIMJ[2].width, LIMJ[2].height);
		g.drawRect(LIMJ[3].x, LIMJ[3].y, LIMJ[3].width, LIMJ[3].height);*/
		//g.fillRect(0, 0, (int) (Konstantj.fenestrLargx/1.7), (int) (Konstantj.fenestrAlt/1.7));
		//((Graphics2D)g).drawImage(sprite.spritejn(0, direkt), AffineTransform.getRotateInstance(x/16, 64,64), null);
		
	}
	
}