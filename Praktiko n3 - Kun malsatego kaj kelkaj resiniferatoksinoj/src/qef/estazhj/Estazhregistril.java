package qef.estazhj;

import qef.estazhj.vivazhj.Zombi;

public class Estazhregistril {

	public static Estazh estazhjn(final int id) {
		switch(id) {
			case 0:
				return new Zombi(id);
			default:
				return new Zombi(id);//TODO fek' plibonigu tion
		}
	}
}
