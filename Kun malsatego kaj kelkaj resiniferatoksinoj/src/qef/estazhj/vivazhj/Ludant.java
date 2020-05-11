package qef.estazhj.vivazhj;

import java.awt.Rectangle;
import java.awt.Transparency;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.inventar.armil.Armil;
import qef.inventar.armil.Senarma;
import qef.kontrolj.Kontrolperant;
import qef.sprite.SpriteFoli;
import qef.uzantinterfac.Text;

public class Ludant extends Vivazh {
	
	private int experienc = 100;
	public static final SpriteFoli armatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 1 + ".png", 32,
			Transparency.TRANSLUCENT, 128);
//	private static final SpriteFoli senarmatludantsprite = new SpriteFoli(Konstantj.ITENER_ZOMBI + 0 + ".png", 32,
//			Transparency.TRANSLUCENT, 128);//TODO Mi eble unigos cxi tion en unu "array"
	private static final SpriteFoli senarmatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT, 128);
	public Ludant() {
		super(0, 4, senarmatludantsprite, Konstantj.ITENER_SONJ_LUDANT + "pom.wav");

		this.x = QefObjektj.map.komencpunktX;
		this.y = QefObjektj.map.komencpunktY;
		largxVivazh = 16;
		altVivazh = 16;
		
		LIMJ[0] = new Rectangle(Konstantj.duonLudLargx - largxVivazh + 1, Konstantj.duonLudAlt - altVivazh,
				Konstantj.SPRITELARGX - 2, 1);
		LIMJ[1] = new Rectangle(Konstantj.duonLudLargx - largxVivazh + 1, Konstantj.duonLudAlt + altVivazh - 1,
				Konstantj.SPRITELARGX - 2, 1);
		LIMJ[2] = new Rectangle(Konstantj.duonLudLargx - largxVivazh, Konstantj.duonLudAlt - altVivazh + 1, 1,
				Konstantj.SPRITEALT - 2);
		LIMJ[3] = new Rectangle(Konstantj.duonLudLargx + largxVivazh, Konstantj.duonLudAlt - altVivazh + 1, 1,
				Konstantj.SPRITEALT - 2);
	}
	
	@Override
	public void gxisdatig() {
		gxisdatigArmiljn();
		yangxMapn();
		yangxResistencn();
		yangxSpriten();
		mov();
		anim(movante);
	}
	
	private void mov() {
		
		boolean[] kolicie = {qnekolicie(0), qnekolicie(1), qnekolicie(2), qnekolicie(3), qena()};
		
		if(Kontrolperant.klavar.supr.pulsitan() && kolicie[0]) {
			movante = true;
			if(Kontrolperant.klavar.dextr.pulsitan() && kolicie[3]) {
				direkt = 5;
				yangxRapidec();
				pliX();
				mlpliY();
			}else if(Kontrolperant.klavar.mldextr.pulsitan() && kolicie[2]) {
				direkt = 8;
				yangxRapidec();
				mlpliX();
				mlpliY();
			}else {
				direkt = 4;
				yangxRapidec();
				mlpliY();
			}
		}
		if(Kontrolperant.klavar.sub.pulsitan() && kolicie[1]) {
			movante = true;
			if(Kontrolperant.klavar.dextr.pulsitan() && kolicie[3]) {
				direkt = 7;
				yangxRapidec();
				pliX();
				pliY();
			}else if(Kontrolperant.klavar.mldextr.pulsitan() && kolicie[2]) {
				direkt = 3;
				yangxRapidec();
				mlpliX();
				pliY();
			}else {
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
		else if(restarigad == Konstantj.plejRestarigad && Text.RES.kvantn() < Konstantj.plejResistenc)
			Text.RES.pliigKvantn();
	}
	
	private void yangxSpriten() {
		if(Konstantj.qyangxSpriteFoli) {
			Konstantj.qyangxSpriteFoli = false;
			if(vivazharmilar.armil1n() instanceof Senarma) {
				setSpriteFoli(senarmatludantsprite, 0);
				return;
			}
			if(vivazharmilar.armil1n() instanceof Armil)
				setSpriteFoli(armatludantsprite, 0);
		}
	}
	
	private void yangxRapidec() {
		
		if(Kontrolperant.klavar.kuri && Text.RES.kvantn() > 0) {
			rapidec = 2.8f;
			frekvenciAnimaci = 2;
			Text.RES.mlpliigKvantn();;
			restarigad = 0;
		}else {
			rapidec = 0.7f;
			frekvenciAnimaci = 8;
		}
		
	}
	private void gxisdatigArmiljn() {
		if(vivazharmilar.armil1n() instanceof Senarma)
			return;
		
		vivazharmilar.armil1n().gxisdatig();
		nunatingec = vivazharmilar.armil1n().atingec(this);
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnBildn(bildj[nunBild], Konstantj.largxCentr, Konstantj.altCentr);
	}
	
	public int experiencn() {
		return experienc;
	}
	
}