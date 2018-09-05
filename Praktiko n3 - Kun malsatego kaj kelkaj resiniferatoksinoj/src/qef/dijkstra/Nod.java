package qef.dijkstra;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Nod {
	
	private Point posici;
	private double distanc;
	
	public Nod(final Point posicio, final double distanco) {
		posici = posicio;
		distanc = distanco;
	}
	
	public void desegn() {
		DebugDesegn.desegnString(String.format("%.2f", distanc),
				(int) Kvantperant.koordenadXalekranPosicin(posici.x*Konstantj.SPRITEFLANK),
				(int) Kvantperant.koordenadYalekranPosicin(posici.y*Konstantj.SPRITEFLANK + 15), Color.ORANGE);
	}
	
	public Rectangle pixeleAre() {
		return new Rectangle(posici.x * Konstantj.SPRITEFLANK, posici.y * Konstantj.SPRITEFLANK,
				Konstantj.SPRITEFLANK, Konstantj.SPRITEFLANK);
	}
	
	public Rectangle aren() {
		return new Rectangle(posici.x, posici.y, Konstantj.SPRITEFLANK, Konstantj.SPRITEFLANK);
	}
	
	public Point posicin() {
		return posici;
	}
	
	public void setDistancn(final double distanco) {
		distanc = distanco;
	}
	
	public double distancn() {
		return distanc;
	}
}