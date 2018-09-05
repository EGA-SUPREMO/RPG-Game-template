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
	private boolean qclick2;
	
	public Muy(final Canvas canvas) {
		
		Toolkit i = Toolkit.getDefaultToolkit();
		
		BufferedImage ikon = YargxilAzhj.yargxBildn("/icons/cursor.png", Transparency.TRANSLUCENT);
		
		kursor = i.createCustomCursor(ikon, new Point(0, 0), "Kursoro defauxlta");

		qclick = false;
		qclick2 = false;
		this.canvas = canvas;
		posici = new Point();
		reskalitPosici = new Point();
		
		gxisdatigPosicijn();
		
	}
	
	public void gxisdatig() {
		gxisdatigPosicijn();
		resetQclickjn();
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
	public boolean qclick2n() {
		return qclick2;
	}
	public void resetQclickjn() {
		qclick = false;
		qclick2 = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			qclick = true;
		} else if (SwingUtilities.isRightMouseButton(e)) {
			qclick2 = true;
		}
	}
	
}