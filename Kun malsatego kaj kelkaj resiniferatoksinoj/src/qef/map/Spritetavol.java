package qef.map;

public class Spritetavol extends Tavol {
	
	private int[] sprites;
	
	public Spritetavol(int ancho, int alto, int x, int y, int[] sprites) {
		super(ancho, alto, x, y);
		this.sprites = sprites;
	}
	
	public int[] obtenerArraySprites() {
		return sprites;
	}

}
