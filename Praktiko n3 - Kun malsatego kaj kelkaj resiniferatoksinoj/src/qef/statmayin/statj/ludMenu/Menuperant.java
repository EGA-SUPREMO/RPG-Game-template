package qef.statmayin.statj.ludMenu;

import qef.grafikj.Superficdesegn;
import qef.kontrolj.Muy;
import qef.statmayin.Statlud;

public class Menuperant implements Statlud {
	
	private final Muy muy;
	private final MenuStrutur menu;
	
	private final MenuSekci[] sekcij;
	private MenuSekci aktivsekci;
	
	public Menuperant(final Muy muyo, final Superficdesegn sd) {
		muy = muyo;
		
		menu = new MenuStrutur();
		sekcij = new MenuSekci[2];
		sekcij[0] = new InventarMenu(menu.fonn(), sd, menu);
		sekcij[1] = new ArmazhMenu();
		
		aktivsekci = sekcij[0];
	}
	
	@Override
	public void gxisdatig() {
		menu.gxisdatig();
		
		for(int i = 0; i<sekcij.length;i++)
			if(muy.qclickn() && muy.rectangleReskalitPosicin().intersects(sekcij[i].ETIKED_MENU)) {
				aktivsekci = sekcij[i];
				break;
			}
		muy.resetQclickn();
	}
	
	@Override
	public void desegn() {
		menu.desegn();
		for(int i = 0; i<sekcij.length;i++)
			sekcij[i].desegnEtikedn(muy.rectangleReskalitPosicin(), aktivsekci);
		aktivsekci.desegn();
	}
	
	public MenuStrutur menun() {
		return menu;
	}
	
	public MenuSekci Aktivsekcin () {
		return aktivsekci;
	}
	
}
