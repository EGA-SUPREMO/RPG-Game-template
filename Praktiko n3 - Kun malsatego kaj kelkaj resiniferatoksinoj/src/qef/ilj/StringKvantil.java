package qef.ilj;

import java.awt.Graphics;

public class StringKvantil {
	
	private static Graphics g;
	
	public static void definigad(final Graphics gg) {
		g = gg;
	}
	public static int largxStringn(final String str) {
		return g.getFontMetrics().stringWidth(str);
	}
	public static int altStringn(final String str) {
		return (int) g.getFontMetrics().getLineMetrics(str, g).getHeight();
	}
	
}