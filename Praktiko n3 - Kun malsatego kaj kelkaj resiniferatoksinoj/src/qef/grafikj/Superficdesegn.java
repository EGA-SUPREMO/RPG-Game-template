package qef.grafikj;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDatum;
import qef.ilj.DebugDesegn;
import qef.kontrolj.Kontrolperant;
import qef.kontrolj.Muy;
import qef.statmayin.Statperant;
import qef.uzantinterfac.Text;

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
		addMouseListener(muy);
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
		
		DebugDesegn.setColor(Color.BLACK);//mi havas taskon relatita al tiu
		DebugDesegn.desegnRectangle(0, 0, Konstantj.plejfenestrLargx, Konstantj.plejfenestrAlt);
		
		g.setFont(Konstantj.KUTIM_FONT);
		
		if(Konstantj.faktorX != 1 || Konstantj.faktorY != 1)
			((Graphics2D) g).scale(Konstantj.faktorX, Konstantj.faktorY);
		
		DebugDesegn.setColor(Konstantj.ANTAWDEFINIT_KOLOR);
		sp.desegn();
		
		DebugDesegn.setColor(Konstantj.ANTAWDEFINIT_KOLOR);
		
		DebugDesegn.desegnString("APS: " + Konstantj.aps, 10, 20);
		DebugDesegn.desegnString("FPS: " + Konstantj.fps, 10, 30);
		
		DebugDatum.addDatumn("X: " + QefObjektj.ludant.xn());
		DebugDatum.addDatumn("Y: " + QefObjektj.ludant.yn());
		DebugDatum.addDatumn("Sekundoj pasitaj: " + Konstantj.sekundjPasita);
		try {
		DebugDatum.addDatumn("Promedio de fps po sekundo: " + Konstantj.qiufps/Konstantj.sekundjPasita);
		}catch(ArithmeticException e) {/*e.printStackTrace();*/}
		DebugDatum.addDatumn("Res: " + Text.RES.kvantn());
		DebugDatum.addDatumn("Restarigado: " + QefObjektj.ludant.restarigadn());
		DebugDatum.addDatumn("Faktoro X: " + Konstantj.faktorX);
		DebugDatum.addDatumn("Faktoro Y: " + Konstantj.faktorY);
		DebugDatum.addDatumn("Venonta mapo: " + QefObjektj.ludant.mapn().venontMapn());
		DebugDatum.addDatumn("Komenca posicio X: " + QefObjektj.ludant.mapn().xLudantn());
		DebugDatum.addDatumn("Komenca posicio Y: " + QefObjektj.ludant.mapn().yLudantn());
		DebugDatum.addDatumn("OPF: " + DebugDesegn.objektjDesegnitan());
		
		DebugDatum.addDatumn("RX: " + muy.posicin().x);
		DebugDatum.addDatumn("RY: " + muy.posicin().y);
		DebugDatum.addDatumn("Reskalita RX: " + muy.rectangleReskalitPosicin().x);
		DebugDatum.addDatumn("Reskalita RY: " + muy.rectangleReskalitPosicin().y);
		
		if(Kontrolperant.klavar.debug) {
			if(sp.qStatludn())
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