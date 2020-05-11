package qef.statmayin.statj.ludMenu;

import qef.QefObjektj;
import qef.kontrolj.Muy;
import qef.statmayin.Statlud;

public class Menuperant implements Statlud {
	
	private final Muy muy;
	private final MenuStrutur menu;
	
	private final MenuSekci[] sekcij;
	private MenuSekci aktivsekci;
	
	public Menuperant() {
		muy = QefObjektj.superfic.muyn();
		
		menu = new MenuStrutur();
		sekcij = new MenuSekci[2];
		sekcij[0] = new InventarMenu(menu);
		sekcij[1] = new ArmazhMenu((InventarMenu) sekcij[0], menu);
		
		aktivsekci = sekcij[0];
	}
	
	@Override
	public void gxisdatig() {
		menu.gxisdatig();
		
		for(int i = 0; i<sekcij.length;i++)
			if(muy.qclickn() && muy.rectangleReskalitPosicin().intersects(sekcij[i].ETIKED_MENU)) {
				if (sekcij[i] instanceof  ArmazhMenu) {
					ArmazhMenu sekci = (ArmazhMenu) sekcij[i];
					if (sekci.selektat != null) {
						sekci.selektat = null;
					}
				}
				aktivsekci = sekcij[i];
				break;
			}
		aktivsekci.gxisdatig();
	}
	
	@Override
	public void desegn() {
		menu.desegn();
		for(int i = 0; i<sekcij.length;i++)
			sekcij[i].desegnEtikedn(muy.rectangleReskalitPosicin(), aktivsekci);
		aktivsekci.desegn();
	}
	
	public MenuSekci sekcijn(final int i) {
		return sekcij[i];
	}
	
	public MenuStrutur menun() {
		return menu;
	}
	
	public MenuSekci Aktivsekcin () {
		return aktivsekci;
	}
	
}
