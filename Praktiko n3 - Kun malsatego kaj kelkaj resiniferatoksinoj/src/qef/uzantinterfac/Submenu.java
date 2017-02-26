package qef.uzantinterfac;

import java.awt.Color;
import java.awt.Rectangle;

import qef.ilj.DebugDesegn;

import static qef.Konstantj.ludAlt;
import static qef.Konstantj.ludLargx;

public class Submenu {
	
	private final static int altMenu = 64;
	private static Rectangle are = new Rectangle(0, ludAlt - altMenu, ludLargx, ludAlt);
	private Rectangle MargxenAre;
	private Verg[] vergj;
	
	public Submenu() {
		
		//are = new Rectangle(0, ludAlt - altMenu, ludLargx, ludAlt);
		MargxenAre = new Rectangle(are.x, are.y - 1, are.width, 1);
		
		vergj = new Verg[4];
		vergj[0] = new Verg(Color.BLUE, Text.VIV);
		vergj[1] = new Verg(Color.YELLOW, Text.RES);
		vergj[2] = new Verg(Color.GREEN, Text.EXP);
		vergj[3] = new Verg(Color.RED, Text.ATK);
		
	}
	
	public void desegn() {
		desegnSubmenufonn();
		desegnSubmenuAzhjn();
	}
	
	private void desegnSubmenufonn() {
		DebugDesegn.setColor(Color.BLACK);
		DebugDesegn.desegnRectangle(are);
		DebugDesegn.setColor(Color.WHITE);
		DebugDesegn.desegnRectangle(MargxenAre);
	}
	
	private void desegnSubmenuAzhjn() {
		for(int i = 0; i < vergj.length; i++)
			vergj[i].desegn();
	}
	
	static int areXn() {
		return are.x;
	}
	
	static int areYn() {
		return are.y;
	}
	
}