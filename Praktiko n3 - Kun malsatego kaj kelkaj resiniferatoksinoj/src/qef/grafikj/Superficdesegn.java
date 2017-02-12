package qef.grafikj;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import qef.Konstantj;
import qef.ilj.DebugDatum;
import qef.ilj.DebugDesegn;
import qef.kontrolj.Kontrolperant;
import qef.kontrolj.Muy;
import qef.statmayin.Statperant;

public class Superficdesegn extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private int largx, alt;
	private Muy muy;
	
	public Superficdesegn(final int largx, final int alt) {
		
		this.largx = largx;
		this.alt = alt;
		this.muy = new Muy(this);
		
		setIgnoreRepaint(true);
		setCursor(muy.kursorn());
		setPreferredSize(new Dimension(largx, alt));
		addKeyListener(Kontrolperant.klavar);
		setFocusable(true);
		requestFocus();
		
	}
	
	public void desegn(final Statperant sp) {
		
		final BufferStrategy bufer = getBufferStrategy();
		
		if(bufer==null) {
			createBufferStrategy(4);//mi havas taskon relatita al tio
			return;
		}
		
		final Graphics g = bufer.getDrawGraphics();
		
		DebugDesegn.definigad(g);
		
		g.setColor(Color.BLACK);//mi havas taskon relatita al tiu
		g.setFont(Konstantj.KUTIM_FONT);
		DebugDesegn.desegnRectangle(0, 0, Konstantj.plejfenestrLargx, Konstantj.plejfenestrAlt);
		
		if(Konstantj.faktorX != 1 || Konstantj.faktorY != 1)
			((Graphics2D) g).scale(Konstantj.faktorX, Konstantj.faktorY);
		
		sp.desegn();
		
		g.setColor(Konstantj.ANTAWDEFINIT_KOLOR);
		
		DebugDesegn.desegnString("APS: " + Konstantj.aps, 10, 10);
		DebugDesegn.desegnString("FPS: " + Konstantj.fps, 10, 20);
		
		DebugDatum.addDatumn("RX: " + muy.posicin().x);
		DebugDatum.addDatumn("RY: " + muy.posicin().y);
		
		if(Kontrolperant.klavar.debug) {
			
			DebugDesegn.desegnKolicijn();
			DebugDatum.desegn();
			
		}
		
		DebugDatum.malplenigDatumjn();
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		
		bufer.show();
		
	}
	
	public int largxn() {
		return largx;
	}
	
	public int altn() {
		return alt;
	}
	
	public Muy muyn() {
		return muy;
	}
	
}