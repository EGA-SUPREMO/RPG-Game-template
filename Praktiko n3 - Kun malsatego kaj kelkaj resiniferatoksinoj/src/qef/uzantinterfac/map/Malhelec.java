package qef.uzantinterfac.map;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;

public class Malhelec {
	
	Rectangle rektMalhelec;
	Color e;
	
	public Malhelec() {
	
		e = new Color(0, 0, 0, 0);//TODO MERDO
		rektMalhelec = new Rectangle(0, 0, Konstantj.ludLargx,Konstantj.ludAlt - Konstantj.altSubmenu);
		
	}
	
	public void desegn() {
		
		DebugDesegn.setColor(e);
		DebugDesegn.desegnRectangle(rektMalhelec);
	}
	
}