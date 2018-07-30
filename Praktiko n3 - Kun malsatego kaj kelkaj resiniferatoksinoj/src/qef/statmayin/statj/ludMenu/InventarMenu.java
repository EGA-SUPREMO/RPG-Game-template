package qef.statmayin.statj.ludMenu;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.grafikj.Superficdesegn;
import qef.ilj.DebugDesegn;
import qef.ilj.StringKvantil;
import qef.ilj.TooltipGeneril;

public class InventarMenu extends MenuSekci {

	private final static int ITEM_LARGXEC = Konstantj.SPRITEFLANK/2 - Konstantj.SPRITEFLANK/8;
	private final static int ITEM_ALTEC = Konstantj.SPRITEFLANK/4;
	private Rectangle pezVerg;
	private int plejpez, nunpez;
	
	private Superficdesegn sd;
	private MenuStrutur ms;
	
	private int gxeneralMargxen = 8;
	
	public InventarMenu(final Rectangle fon, final Superficdesegn sdo, final MenuStrutur mso) {
		super("Inventaro");
		
		int vergAlt = 8;
		
		plejpez = 100;
		nunpez = 20;
		
		pezVerg = new Rectangle(Konstantj.ludLargx - MenuStrutur.ETIKED_LARGX - gxeneralMargxen, fon.y
				+ gxeneralMargxen, MenuStrutur.ETIKED_LARGX, vergAlt);
		
		sd = sdo;
		ms = mso;
	}

	@Override
	public void desegn() {
		desegnPezVerg();
		desegnItemj(ms);
		desegnTooltipj(sd);//GXI uzas la Superficdesegn sen gxisdatigi
	}
	
	private void desegnPezVerg() {
		DebugDesegn.desegnRectangle(pezVerg, Color.GRAY);
		DebugDesegn.desegnRectangle(pezVerg.x + 1, pezVerg.y + 1, pezVerg.width/plejpez*nunpez - 2,
				pezVerg.height - 2, Konstantj.KOLOR_SUPR_BANNER);
		DebugDesegn.setColor(Color.GRAY);
		DebugDesegn.desegnString("Pezo:", pezVerg.x - 30, pezVerg.y + 8);
	}

	private void desegnTooltipj(Superficdesegn sd) {
		TooltipGeneril.desegnTooltipn(sd, pezVerg, nunpez + "/" + plejpez);
	}
	
	private void desegnItemj(final MenuStrutur ms) {
		final Point komencPunkt = new Point(ms.fonn().x + gxeneralMargxen * 2, pezVerg.y + pezVerg.height +
				gxeneralMargxen);
		DebugDesegn.setFont(DebugDesegn.Fontn().deriveFont(DebugDesegn.Fontn().getSize()-2));
		
		for(int i = 0; i <  QefObjektj.inventar.objektj.size(); i++) {
			DebugDesegn.desegnBildn(QefObjektj.inventar.objektj.get(i).spriten(), komencPunkt.x +
					i*(gxeneralMargxen + Konstantj.SPRITEFLANK), komencPunkt.y);
			
			DebugDesegn.setColor(Color.BLACK);
			DebugDesegn.desegnRectangle(komencPunkt.x + i*(gxeneralMargxen + Konstantj.SPRITEFLANK) +
					Konstantj.SPRITEFLANK - ITEM_LARGXEC, komencPunkt.y + Konstantj.SPRITEFLANK - ITEM_ALTEC,
					ITEM_LARGXEC, ITEM_ALTEC);

			final String text = "" + QefObjektj.inventar.objektj.get(i).kvantn();
			
			DebugDesegn.setColor(Color.WHITE);
			DebugDesegn.desegnString(text, komencPunkt.x + i*(gxeneralMargxen + Konstantj.SPRITEFLANK) +
					Konstantj.SPRITEFLANK - StringKvantil.largxStringn(text), komencPunkt.y + Konstantj.SPRITEFLANK -
					1);
			
		}
		
		DebugDesegn.setFont(DebugDesegn.Fontn().deriveFont(DebugDesegn.Fontn().getSize()+2));
		
	}
	
	@Override
	public void gxisdatig() {
	}
	
}
