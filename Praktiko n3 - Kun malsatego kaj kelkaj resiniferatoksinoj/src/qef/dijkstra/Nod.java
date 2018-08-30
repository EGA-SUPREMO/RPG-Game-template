package qef.dijkstra;

import java.awt.Point;
import java.awt.Rectangle;

import qef.Konstantj;

public class Nod {
	
	private Point posici;
	private double distanc;
	
	public Nod(final Point posicio, final double distanco) {
		posici = posicio;
		distanc = distanco;
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