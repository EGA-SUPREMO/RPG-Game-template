package qef.statmayin.statj.ludMenu;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;

public class MenuStrutur {
	
	private Color kolorSuprBanner;
	private Color kolorSubBanner;
	private Color kolorFon;
	
	private Rectangle suprBanner;
	private Rectangle subBanner;
	private Rectangle fon;
	
	public final int VERTIKAL_MARGXEN;
	public final int HORIZONTAL_MARGXEN;
	public final int ETIKED_LARGX;
	public final int ETIKED_ALT;
	
	public MenuStrutur() {
		
		kolorSuprBanner = Color.CYAN;
		kolorSubBanner = Color.CYAN.darker();
		kolorFon = Color.WHITE;
		
		suprBanner = new Rectangle(0, 0, Konstantj.ludLargx, 20);
		subBanner = new Rectangle(suprBanner.x, suprBanner.height + suprBanner.y, 140, Konstantj.ludAlt - suprBanner.height);
		fon = new Rectangle(subBanner.width + subBanner.x, subBanner.y, Konstantj.ludLargx - subBanner.width, Konstantj.ludAlt - suprBanner.height);
		
		VERTIKAL_MARGXEN = 20;
		HORIZONTAL_MARGXEN = 20;
		ETIKED_LARGX = 100;
		ETIKED_ALT = 20;
		
	}
	
	public void gxisdatig() {
		
	}
	
	public void desegn() {

		DebugDesegn.desegnRectangle(suprBanner, kolorSuprBanner);
		DebugDesegn.desegnRectangle(subBanner, kolorSubBanner);
		DebugDesegn.desegnRectangle(fon, kolorFon);
		
	}
	
}