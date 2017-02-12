package qef.kontrolj;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import qef.ilj.YargxilAzhj;

public class Muy extends MouseAdapter{//Musxo
	
	private final Cursor kursor;
	private Point posici;
	private Canvas canvas;
	
	public Muy(final Canvas canvas) {
		
		Toolkit i = Toolkit.getDefaultToolkit();
		
		BufferedImage ikon = YargxilAzhj.yargxBildn("/icons/cursor.png", Transparency.TRANSLUCENT);
		
		kursor = i.createCustomCursor(ikon, new Point(0, 0), "Kursoro defauxlta");
		
		this.canvas = canvas;
		posici = new Point();
		gxisdatigPosicin();
		
	}
	
	public void gxisdatig() {
		gxisdatigPosicin();
	}
	
	private void gxisdatigPosicin() {
		final Point komencPosici = MouseInfo.getPointerInfo().getLocation();
		
		SwingUtilities.convertPointFromScreen(komencPosici, canvas);
		
		posici.setLocation(komencPosici);
	}
	
	public Point posicin() {
		return posici;
	}
	
	public Cursor kursorn() {
		return kursor;
	}
	
}