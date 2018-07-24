package qef.ilj;

import java.awt.Point;
import java.awt.Rectangle;

import qef.Konstantj;

public class Reskalilj {
	
	public static Rectangle reskalRectanglen(final Rectangle r) {
		return new Rectangle((int) (r.x * Konstantj.faktorX), (int) (r.y * Konstantj.faktorY), (int)
				(r.width * Konstantj.faktorX), (int) (r.height * Konstantj.faktorY));
	}

	public static Point reskalSupernPunktn(final Point p) {
		return new Point((int) (p.x * Konstantj.faktorX), (int) (p.y * Konstantj.faktorY));
	}
	
	public static Point reskalSubenPunktn(final Point p) {
		return new Point((int) (p.x / Konstantj.faktorX), (int) (p.y / Konstantj.faktorY));
	}
	
}
