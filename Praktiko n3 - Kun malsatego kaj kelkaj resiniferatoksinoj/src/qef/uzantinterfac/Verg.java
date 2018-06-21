package qef.uzantinterfac;

import java.awt.Color;
import java.awt.Point;

import qef.ilj.DebugDesegn;

public class Verg {

	private int MEZUR_VERTIKAL = 4;
	private final static int GRANDEC_VERTIKAL = 4;
	private Color kolor, darkKolor;
//	private static int id = 0;
	private static int largx = 100;
	private Point posici;
	private Text text;
	
	public Verg(final Color kolor, final Text text) {
		
		this.kolor = kolor;
		this.darkKolor = kolor.darker();
		this.text = text;
		
		MEZUR_VERTIKAL = GRANDEC_VERTIKAL * (text.ordinal() * 4);
		posici = new Point(Submenu.areXn() + 35, Submenu.areYn() + MEZUR_VERTIKAL + GRANDEC_VERTIKAL);
		//setPosicin();
		
	}
	
	public void desegn() {
		desegnVergn();
		desegnTextn();
	}
	
	private void desegnTextn() {
		DebugDesegn.desegnString(text.name(), posici.x - 19, posici.y + 8);
		DebugDesegn.desegnString("" + text.kvantn(), posici.x + 102, posici.y + 8);
	}
	
	private void desegnVergn() {
		
/*		System.out.println("REPORTANDOSE " + this + " CON LAS CONDICIONES DE " + posici.y + " Y " + text.name() + " EN LA " +
				text.ordinal() + " ROTACION, PERIDOD FUERA");*/
		
/*		System.out.println("REPORTANDOSE " + this + " CON LAS CONDICIONES DE " + posici.y + " Y " + text.name() + " EN LA " +
				text.ordinal() + " ROTACION, PERIDOD FUERA");*/
		
		DebugDesegn.setColor(kolor);
		DebugDesegn.desegnRectangle(posici.x, posici.y, text.kvantn() * largx / text.plejkvantn(), GRANDEC_VERTIKAL);
		
		posici.y += GRANDEC_VERTIKAL;
		
		DebugDesegn.setColor(darkKolor);
		DebugDesegn.desegnRectangle(posici.x, posici.y, text.kvantn() * largx / text.plejkvantn(), GRANDEC_VERTIKAL);
		
		posici.y -= GRANDEC_VERTIKAL;
		
	}
	/*
	private void setPosicin() {
		id++;
		posici.setLocation(QefObjektj.submenu.areXn() + 35, QefObjektj.submenu.areYn() + MEZUR_VERTIKAL << id);
	}*/
	
}