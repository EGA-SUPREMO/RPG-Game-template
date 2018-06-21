package qef.uzantinterfac;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;

public class Elektebl {

	private final static int GRANDEC = 32;
	private final static int DUON_GRANDEC = GRANDEC>>1;
	private final static int SPAC = 150;
	private static Color kolor = Color.ORANGE.brighter();
	private String text;
	private final Rectangle rect;
	
	public Elektebl(final int id) {
		
		this.text = id + "";
		
		rect = new Rectangle(Submenu.areXn() + (((Konstantj.ludLargx - SPAC) / (Submenu.kvantElektebln() + 1) * (id + 1)) - DUON_GRANDEC
				+ SPAC), Submenu.areYn() + DUON_GRANDEC, GRANDEC, GRANDEC);
		
	}
	
	public void desegn() {
		
		DebugDesegn.setColor(kolor);
		DebugDesegn.desegnRectangle(rect);
		DebugDesegn.desegnString(text, rect.x + DUON_GRANDEC - 3, rect.y + GRANDEC + 10);
		
	}
	
	public static void setKolorn(final Color koloro) {
		kolor = koloro;
	}
	
}