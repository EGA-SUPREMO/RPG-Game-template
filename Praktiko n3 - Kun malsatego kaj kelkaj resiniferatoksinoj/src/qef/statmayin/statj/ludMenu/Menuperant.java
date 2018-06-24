package qef.statmayin.statj.ludMenu;

import qef.statmayin.Statlud;

public class Menuperant implements Statlud {
	
	private final MenuStrutur menu;
	
	private final MenuSekci[] sekcij;
	
	public Menuperant() {
		menu = new MenuStrutur();
		sekcij = new MenuSekci[2];
		sekcij[0] = new InventarMenu();
		sekcij[1] = new ArmazhMenu();
	}
	
	@Override
	public void gxisdatig() {
		menu.gxisdatig();
	}
	
	@Override
	public void desegn() {
		menu.desegn();
		for(int i = 0; i<sekcij.length;i++)
			sekcij[i].desegnEtikedn();
	}
	
	public MenuStrutur menun() {
		return menu;
	}
	
}
