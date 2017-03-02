package qef.statmayin.statj.ludMenu;

import qef.statmayin.Statlud;

public class Menuperant implements Statlud {
	
	private final MenuStrutur menu;
	
	public Menuperant() {
		menu = new MenuStrutur();
	}
	
	@Override
	public void gxisdatig() {
		menu.gxisdatig();
	}
	
	@Override
	public void desegn() {
		menu.desegn();
	}
	
}
