package qef.statmayin.statj.ludMenu;

import java.awt.Color;
import java.awt.Rectangle;

import qef.ilj.DebugDesegn;

public abstract class MenuSekci {
	
	protected final Rectangle ETIKED_MENU;
	protected final String NOM;
	protected final int ID;
	private static int id = 0;
	
	public MenuSekci(final String nomo) {
		id++;
		ID = id;
		NOM = nomo;
		ETIKED_MENU = new Rectangle(MenuStrutur.HORIZONTAL_MARGXEN, ID*MenuStrutur.ETIKED_ALT + ID*MenuStrutur.VERTIKAL_MARGXEN,
				MenuStrutur.ETIKED_LARGX, MenuStrutur.ETIKED_ALT);
	}
	
	public abstract void desegn();
	
	public void desegnEtikedn() {
		DebugDesegn.desegnRectangle(ETIKED_MENU, Color.CYAN);
		DebugDesegn.setColor(Color.BLACK);
		DebugDesegn.desegnString(NOM, ETIKED_MENU.x + 17, ETIKED_MENU.y + 15);
	}
	
	public abstract void gxisdatig();
	
	public String NOMN() {
		return NOM;
	}
	
}