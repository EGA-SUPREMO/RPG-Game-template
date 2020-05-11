package qef.statmayin.statj.ludMenu;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;

public abstract class MenuSekci {
	
	protected final Rectangle ETIKED_MENU;
	protected final String NOM;
	protected final int ID;
	private static int id = 0;
	
	protected int gxeneralMargxen = 8;
	
	public MenuSekci(final String nomo) {
		id++;
		ID = id;
		NOM = nomo;
		ETIKED_MENU = new Rectangle(MenuStrutur.HORIZONTAL_MARGXEN, ID*MenuStrutur.ETIKED_ALT +
				ID*MenuStrutur.VERTIKAL_MARGXEN, MenuStrutur.ETIKED_LARGX, MenuStrutur.ETIKED_ALT);
	}
	
	public abstract void desegn();
	
	public void desegnEtikedn(final Rectangle muy, final MenuSekci aktivsekci) {
		if(ETIKED_MENU.intersects(muy))
			DebugDesegn.desegnRectangle(ETIKED_MENU.x - 3, ETIKED_MENU.y - 3, ETIKED_MENU.width + 6,
				ETIKED_MENU.height + 6, Konstantj.AKTIV_ETIKED_BOTON_KOLOR);
		DebugDesegn.desegnRectangle(ETIKED_MENU, Color.CYAN);
		DebugDesegn.setColor(Color.BLACK);
		DebugDesegn.desegnString(NOM, ETIKED_MENU.x + 17, ETIKED_MENU.y + 15);
		if(aktivsekci == this)
			DebugDesegn.desegnRectangle(ETIKED_MENU.x + 3, ETIKED_MENU.y + 3, 5, ETIKED_MENU.height - 6,
				Color.GREEN);
	}
	
	public abstract void gxisdatig();
	
	public String NOMN() {
		return NOM;
	}
	
}