package qef.statmayin.statj.ludMenu;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.grafikj.Superficdesegn;
import qef.ilj.DebugDesegn;
import qef.ilj.TooltipGeneril;

public class InventarMenu extends MenuSekci {
	
	private Rectangle pezVerg;
	private int plejpez, nunpez;
	
	private Superficdesegn sd;
	
	private int gxeneralMargxen = 8;
	
	public InventarMenu(final Rectangle fon, final Superficdesegn sdo) {
		super("Inventaro");
		
		int vergAlt = 8;
		
		plejpez = 100;
		nunpez = 20;
		
		pezVerg = new Rectangle(Konstantj.ludLargx - MenuStrutur.ETIKED_LARGX - gxeneralMargxen, fon.y
				+ gxeneralMargxen, MenuStrutur.ETIKED_LARGX, vergAlt);
		
		sd = sdo;
	}

	@Override
	public void desegn() {
		desegnPezVerg();
		desegnTooltipj(sd);//GXI uzas la Superficdesegn sen gxisdatigi
	}
	private void desegnPezVerg() {
		DebugDesegn.desegnRectangle(pezVerg, Color.GRAY);
		DebugDesegn.desegnRectangle(pezVerg.x + 1, pezVerg.y + 1, pezVerg.width/plejpez*nunpez - 2,
				pezVerg.height - 2, Konstantj.KOLOR_SUPR_BANNER);
		DebugDesegn.setColor(Color.GRAY);
		DebugDesegn.desegnString("Pezo:", pezVerg.x - 30, pezVerg.y + 8);
	}

	public void desegnTooltipj(Superficdesegn sd) {
		
		TooltipGeneril.desegnTooltipn(sd, nunpez + "/" + plejpez);
		
	}
	
	@Override
	public void gxisdatig() {
	}
	
}
