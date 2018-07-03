package qef.kontrolj;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import qef.Konstantj;
import qef.ilj.YargxilAzhj;

public class Muy extends MouseAdapter {//Musxo
	
	private final Cursor kursor;
	private Point posici, reskalitPosici;
	private Canvas canvas;
	
	private boolean qclick;
	
	public Muy(final Canvas canvas) {
		
		Toolkit i = Toolkit.getDefaultToolkit();
		
		BufferedImage ikon = YargxilAzhj.yargxBildn("/icons/cursor.png", Transparency.TRANSLUCENT);
		
		kursor = i.createCustomCursor(ikon, new Point(0, 0), "Kursoro defauxlta");
		
		qclick = false;
		this.canvas = canvas;
		posici = new Point();
		reskalitPosici = new Point();
		
		gxisdatigPosicijn();
		
	}
	
	public void gxisdatig() {
		gxisdatigPosicijn();
	}
	
	private void gxisdatigPosicijn() {
		final Point komencPosici = MouseInfo.getPointerInfo().getLocation();

		SwingUtilities.convertPointFromScreen(komencPosici, canvas);
		
		posici.setLocation(komencPosici);
		reskalitPosici.setLocation(komencPosici.x/Konstantj.faktorX, komencPosici.y/Konstantj.faktorY);
	}
	
	public Point posicin() {
		return posici;
	}
	public Cursor kursorn() {
		return kursor;
	}
	public Rectangle rectangleReskalitPosicin() {
		return new Rectangle(reskalitPosici.x, reskalitPosici.y, 1, 1);
	}
	public boolean qclickn() {
		return qclick;
	}
	public void resetQclickn() {
		qclick = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!qclick)
			qclick = true;
	}
}