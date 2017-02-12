package qef.statmayin;

import qef.statmayin.statj.lud.Ludperant;

public class Statperant {
	
	private Statlud[] statj;
	private Statlud nunStat;
	
	public Statperant() {
		ekStatj();
		definNunStatn();
	}

	private void ekStatj() {
		statj = new Statlud[1];
		statj[0] = new Ludperant();
		//Aldunu pli da statoj kaj pliigu la nombron
	}
	
	private void definNunStatn() {
		nunStat = statj[0];
	}
	
	public void yangxNunStatn(final int posicio) {
		nunStat = statj[posicio];
	}
	
	public Statlud nunStatn() {
		return nunStat;
	}
	
	public void gxisdatig() {
		nunStat.gxisdatig();
	}
	
	public void desegn() {
		nunStat.desegn();
	}
	
}