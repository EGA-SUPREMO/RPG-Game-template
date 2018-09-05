package qef.ilj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;

public class DebugDesegn {
	
	private static int objektjDesegnita;
	private static Graphics g;
	
	public static void definigad(final Graphics gg) {
		g = gg;
		objektjDesegnita = 0;
	}
	
	public static void desegnString(final String str, final int x, final int y) {
		objektjDesegnita++;
		g.drawString(str, x, y);
	}
	public static void desegnString(final String str, final int x, final int y, final Color c) {
		objektjDesegnita++;
		g.setColor(c);
		g.drawString(str, x, y);
	}

	public static void desegnRectangle(final Rectangle rect) {
		objektjDesegnita++;
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnMargxenRectangle(final Rectangle rect) {
		objektjDesegnita++;
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnRectangle(final int x, final int y, final int largx, final int alt) {
		objektjDesegnita++;
		g.fillRect(x, y, largx, alt);
	}
	
	public static void desegnMargxenRectangle(final int x, final int y, final int largx, final int alt) {
		objektjDesegnita++;
		g.drawRect(x, y, largx, alt);
	}
	
	public static void desegnRectangle(final Rectangle rect, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnMargxenRectangle(final Rectangle rect, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnRectangle(final int x, final int y, final int largx, final int alt, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.fillRect(x, y, largx, alt);
	}
	
	public static void desegnMargxenRectangle(final int x, final int y, final int largx, final int alt, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.drawRect(x, y, largx, alt);
	}
	
	public static void desegnBildn(final BufferedImage bild, final int x, final int y) {
		objektjDesegnita++;
		g.drawImage(bild, x, y, null);
	}
	
	public static void desegnKolicijn() {
		
		for(int i = 0; i < QefObjektj.map.gxisdatigitArejKolici.size(); i++)
			desegnMargxenRectangle(QefObjektj.map.gxisdatigitArejKolici.get(i));

		for(int i = 0; i < 4; i++)
			desegnRectangle(QefObjektj.ludant.LIMJN()[i]);
		
		for(Vivazh nun : QefObjektj.map.vivazhar)
			for(int i = 0; i < nun.LIMJN().length; i++)
				desegnMargxenRectangle((int) Kvantperant.koordenadXalekranPosicin(nun.LIMJN()[i].x), 
						(int) Kvantperant.koordenadYalekranPosicin(nun.LIMJN()[i].y), nun.LIMJN()[i].width,
						nun.LIMJN()[i].height);
		
	}
	public static void setFont(final Font font) {
		g.setFont(font);
	}
	public static Font Fontn() {
		return g.getFont();
	}
	public static void setColor(final Color c) {
		g.setColor(c);
	}
	
	public static int objektjDesegnitan() {
		return objektjDesegnita;
	}
	
}