package qef.map;

import java.awt.Rectangle;

public class Kolizitavol extends Tavol {

	private Rectangle[] colisionables;
	
	public Kolizitavol(int ancho, int alto, int x, int y, Rectangle[] colisionables) {
		super(ancho, alto, x, y);
		this.colisionables = colisionables;
	}
	
	public Rectangle[] obtenerColisionables() {
		return colisionables;
	}
}
