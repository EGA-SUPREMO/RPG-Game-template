package qef.estazhj;

import qef.Konstantj;
import qef.estazhj.vivazhj.Zombi;

public class Estazhregistril {

	public static Estazh estazhjn(final int id) {
		switch(id) {
			case 0:
				return new Zombi(id, Konstantj.ITENER_SONJ_LUDANT + "pom.wav");
			default:
				return new Zombi(id, Konstantj.ITENER_SONJ_LUDANT + "pom.wav");//TODO fek' plibonigu tion
		}
	}
}
