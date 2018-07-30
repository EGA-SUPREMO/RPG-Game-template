package qef.ilj;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.grafikj.Superficdesegn;
import qef.kontrolj.Muy;

public class TooltipGeneril {
	
	public static void desegnTooltipn(final Superficdesegn sd, final Rectangle lok, final String text) {
		
		final Muy muy = sd.muyn();
		final Point posiciTooltip = Reskalilj.reskalSubenPunktn(generTooltipn(muy.posicin()));
		
		if(lok.intersects(muy.rectangleReskalitPosicin())) {
			final Point centrCanvas = Reskalilj.reskalSupernPunktn(new Point(Konstantj.duonLudLargx,
					Konstantj.duonLudAlt));
			
			final int ancho = StringKvantil.largxStringn(text);
			final int alto = StringKvantil.altStringn(text);
			final int margenFuente = 3;
	
			Rectangle tooltip = new Rectangle(posiciTooltip.x, posiciTooltip.y, ancho + margenFuente, alto);
	
			if (posiciTooltip.x >= centrCanvas.x)
				tooltip.x = posiciTooltip.x - tooltip.width;
			
			DebugDesegn.desegnRectangle(tooltip, Color.black);
			DebugDesegn.desegnString(text, tooltip.x + margenFuente, tooltip.y + tooltip.height - margenFuente,
					Color.white);
		}
	}
		
	private static Point generTooltipn(final Point pi) {
		final int x = pi.x;
		final int y = pi.y;
		
		final Point centrCanvas = Reskalilj.reskalSupernPunktn(new Point(Konstantj.duonLudLargx,
				Konstantj.duonLudAlt));
		
		final int flankKursor = 25;
		final int kursorMargxen = 0;
		
		final Point finPoint = new Point();
		
//		if (x <= centrCanvas.x) 
	//		finPoint.x = x + flankKursor + kursorMargxen;
		//else 
			//finPoint.x = x - flankKursor - kursorMargxen;
		finPoint.x = x;
		if (y <= centrCanvas.y) 
			finPoint.y = y + flankKursor + kursorMargxen;
		else
			finPoint.y = y - flankKursor - kursorMargxen;
		
		return finPoint;
	}
	
}