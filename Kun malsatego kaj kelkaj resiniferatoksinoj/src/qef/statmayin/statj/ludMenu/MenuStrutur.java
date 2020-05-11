package qef.statmayin.statj.ludMenu;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;

public class MenuStrutur {
	
	private Rectangle suprBanner;
	private Rectangle subBanner;
	private Rectangle fon;
	
	public final static int VERTIKAL_MARGXEN = 20;
	public final static int HORIZONTAL_MARGXEN = 20;
	public final static int ETIKED_LARGX = 100;
	public final static int ETIKED_ALT = 20;
	
	public MenuStrutur() {
		
		suprBanner = new Rectangle(0, 0, Konstantj.ludLargx, 20);
		subBanner = new Rectangle(suprBanner.x, suprBanner.height + suprBanner.y, 140, Konstantj.ludAlt - suprBanner.height);
		fon = new Rectangle(subBanner.width + subBanner.x, subBanner.y, Konstantj.ludLargx - subBanner.width, Konstantj.ludAlt - suprBanner.height);
		
	}
	
	public void gxisdatig() {
		
	}
	
	public void desegn() {
		DebugDesegn.desegnRectangle(suprBanner, Konstantj.KOLOR_SUPR_BANNER);
		DebugDesegn.desegnRectangle(subBanner, Konstantj.KOLOR_SUB_BANNER);
		DebugDesegn.desegnRectangle(fon, Konstantj.FONKOLOR);
	}
	
	public Rectangle fonn() {
		return fon;
	}
}