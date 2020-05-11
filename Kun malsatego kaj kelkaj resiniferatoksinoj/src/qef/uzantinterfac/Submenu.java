package qef.uzantinterfac;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;

import static qef.Konstantj.ludAlt;
import static qef.Konstantj.ludLargx;

public class Submenu {
	
	private static Rectangle are = new Rectangle(0, ludAlt - Konstantj.altSubmenu, ludLargx, ludAlt);
	private Rectangle MargxenAre;
	private Verg[] vergj;
	private Elektebl[] elekteblj;
	private static int kvantElektebl = 2;
	
	public Submenu() {
		
		//are = new Rectangle(0, ludAlt - altMenu, ludLargx, ludAlt);
		MargxenAre = new Rectangle(are.x, are.y - 1, are.width, 1);
		
		vergj = new Verg[4];
		vergj[0] = new Verg(Color.BLUE, Text.VIV);
		vergj[1] = new Verg(Color.YELLOW, Text.RES);
		vergj[2] = new Verg(Color.GREEN, Text.EXP);
		vergj[3] = new Verg(Color.RED, Text.ATK);
		
		elekteblj = new Elektebl[2];
		for(int i = 0; i < kvantElektebl; i++) {
			elekteblj[i] = new Elektebl(i);
		}
		
	}
	
	public void desegn() {
		desegnSubmenufonn();
		desegnVergjn();
		desegnElektebljn();
	}
	
	private void desegnSubmenufonn() {
		DebugDesegn.setColor(Color.BLACK);
		DebugDesegn.desegnRectangle(are);
		DebugDesegn.setColor(Color.WHITE);
		DebugDesegn.desegnRectangle(MargxenAre);
	}
	
	private void desegnVergjn() {
		for(int i = 0; i < vergj.length; i++)
			vergj[i].desegn();
	}
	
	private void desegnElektebljn() {
		for(int i = 0; i < elekteblj.length; i++) 
			elekteblj[i].desegn();;
	}
	
	static int kvantElektebln() {
		return kvantElektebl;
	}
	static int areXn() {
		return are.x;
	}
	static int areYn() {
		return are.y;
	}
	
}