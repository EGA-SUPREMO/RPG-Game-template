package qef.inventar;

import qef.Konstantj;
import qef.inventar.armil.Pistol;
import qef.inventar.armil.Senarma;
import qef.inventar.konsumeblezh.Konsumeblezh;

public class Objektregistril {

	public static Objekt objektjn(final int id) {
		
		switch(id) {
			case 0://-----------------------------------0-499 nur konsumeblajxoj-------------------------------------
				return new Konsumeblezh(id, "a", "");
			case 1:
				return new Konsumeblezh(id, "b", "");
			case 2:
				return new Konsumeblezh(id, "d", "");
			case 3:
				return new Konsumeblezh(id, "e", "");
			case 4:
				return new Konsumeblezh(id, "f", "");
			case 5:
				return new Konsumeblezh(id, "g", "");
			case 6:
				return new Konsumeblezh(id, "h", "");
			case 7:
				return new Konsumeblezh(id, "i", "");
			case 500:
				return new Pistol(id, "Acxajxo", "Pistolacxo", 10, 5, false, false, 0.3,
						Konstantj.ITENER_SONJ_LUDANT + "poom.wav");
			case 599:
				return new Senarma(id, "Senarma", "Uzu viajn pugnojn", 1, 1);
			default:
				return new Konsumeblezh(id, "z", "");
		}
		
	}
	
}
