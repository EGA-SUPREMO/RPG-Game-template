package qef.statmayin.statj.ludMenu;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.StringKvantil;
import qef.ilj.TooltipGeneril;
import qef.inventar.Objekt;
import qef.inventar.armil.Armil;
import qef.inventar.armil.Senarma;

public class ArmazhMenu extends MenuSekci {
	
	private InventarMenu menu;
	
	final Rectangle objektpanel;
	final Rectangle titolObjektpanel;
	
	final Rectangle armazhpanel;
	final Rectangle titolArmazhpanel;
	
	final Rectangle ecpanel;
	final Rectangle titolEcpanel;
	
	final Rectangle armiletiked;
	final Rectangle armilar;
	
	Objekt selektat;
	
	public ArmazhMenu(final InventarMenu inventarMenu, final MenuStrutur ms) {
		super("Armajxo");
		menu = inventarMenu;
		objektpanel = new Rectangle(ms.fonn().x + gxeneralMargxen, menu.pezVergn().y + menu.pezVergn().height +
				gxeneralMargxen, 248, Konstantj.ludAlt - menu.pezVergn().y - menu.pezVergn().height -
				gxeneralMargxen*2);
		
		titolObjektpanel = new Rectangle(objektpanel.x, objektpanel.y, objektpanel.width, 24);
		armazhpanel = new Rectangle(objektpanel.x + objektpanel.width + gxeneralMargxen, objektpanel.y, 88,
				objektpanel.height);
		titolArmazhpanel = new Rectangle(armazhpanel.x, armazhpanel.y, armazhpanel.width, 24);
		ecpanel = new Rectangle(armazhpanel.x + armazhpanel.width + gxeneralMargxen, objektpanel.y, 132,
				armazhpanel.height);
		titolEcpanel = new Rectangle(ecpanel.x, ecpanel.y,ecpanel.width, 24);
		
		armiletiked = new Rectangle(titolArmazhpanel.x + gxeneralMargxen, titolArmazhpanel.y +
				titolArmazhpanel.height + gxeneralMargxen, titolArmazhpanel.width - gxeneralMargxen*2,
				gxeneralMargxen*2 + 13);//LA LASTA NOMBRO ESTAS LA ALTECO DE LA VORTO "Armilo"
		armilar = new Rectangle(armiletiked.x + 1, armiletiked.y + armiletiked.height, armiletiked.width - 2,
				Konstantj.SPRITEFLANK);
		
		selektat = null;
	}

	@Override
	public void desegn() {
		menu.desegnPezVerg();
		desegnObjektpaneln();
		desegnArmazhpaneln();
		desegnEcpaneln();
		desegnfloatObjektn();
		TooltipGeneril.desegnTooltipn(QefObjektj.superfic, menu.pezVergn(), 30 + "/" + 100);
	}
	
	private void desegnObjektpaneln() {
		desegnPaneln(objektpanel, titolObjektpanel, "Equipables");
		dibujarElementosEquipables();
	}

	private void dibujarElementosEquipables() {

		if (QefObjektj.inventar.armiljn().isEmpty()) {
			return;
		}

		final Point puntoInicial = new Point(titolObjektpanel.x + gxeneralMargxen,
				titolObjektpanel.y + titolObjektpanel.height + gxeneralMargxen);

		for (int i = 0; i < QefObjektj.inventar.armiljn().size(); i++) {

			int idActual = QefObjektj.inventar.armiljn().get(i).idn();
			Objekt objetoActual = QefObjektj.inventar.objektn(idActual);

			DebugDesegn.desegnBildn(objetoActual.spriten(),	objetoActual.menuposicin().x,
					objetoActual.menuposicin().y);

			DebugDesegn.setColor(Color.black);

			DebugDesegn.desegnRectangle(puntoInicial.x + i * (Konstantj.SPRITEFLANK + gxeneralMargxen) +
					Konstantj.SPRITEFLANK - 12,  puntoInicial.y + 32 - 8, 12, 8);

			DebugDesegn.setColor(Color.white);

			String texto = "";

			if (objetoActual.kvantn() < 10) {
				texto = "0" + objetoActual.kvantn();
			} else {
				texto = "" + objetoActual.kvantn();
			}

			DebugDesegn.setFont(DebugDesegn.Fontn().deriveFont(10f));
			DebugDesegn.desegnString(texto, puntoInicial.x + i * (Konstantj.SPRITEFLANK + gxeneralMargxen) +
					Konstantj.SPRITEFLANK - StringKvantil.largxStringn(texto),
					puntoInicial.y + 31);
		}
		DebugDesegn.setFont(DebugDesegn.Fontn().deriveFont(12f));
	}
	private void desegnArmazhpaneln() {
		desegnPaneln(armazhpanel, titolArmazhpanel, "Armajxo");

		DebugDesegn.setColor(Color.black);

		DebugDesegn.desegnRectangle(armiletiked);
		DebugDesegn.desegnMargxenRectangle(armilar);

        if (!(QefObjektj.ludant.vivazharmilarn().armil1n() instanceof Senarma)) {
            DebugDesegn.desegnBildn(QefObjektj.ludant.vivazharmilarn().armil1n().spriten(),
            		armilar.x + armilar.width / 2 - Konstantj.SPRITEFLANK / 2, armilar.y);
        }

        DebugDesegn.setColor(Color.white);
		DebugDesegn.desegnString("Armilo",
				armiletiked.x + armiletiked.width / 2 - StringKvantil.largxStringn("Armilo") / 2,
				armiletiked.y + armiletiked.height / 2 + StringKvantil.altStringn("Armilo") / 2);
	}

	private void desegnEcpaneln() {
		desegnPaneln(ecpanel, titolEcpanel, "Ecoj");
	}
	
	private void desegnfloatObjektn() {
		if(selektat!=null)
			DebugDesegn.desegnBildn(selektat.spriten(), selektat.floatMenuposicin().x,
					selektat.floatMenuposicin().y);
	}
	private void desegnPaneln(final Rectangle panel, final Rectangle titularPanel,
			final String nombrePanel) {
		DebugDesegn.setColor(new Color(0xff6700));
		DebugDesegn.desegnMargxenRectangle(panel);
		DebugDesegn.desegnRectangle(titularPanel);
		DebugDesegn.setColor(Color.white);
		DebugDesegn.desegnString(nombrePanel, titularPanel.x + titularPanel.width / 2
						- StringKvantil.largxStringn(nombrePanel) / 2,
				titularPanel.y + titularPanel.height - StringKvantil.altStringn(nombrePanel) / 2 - 4);
		DebugDesegn.setColor(new Color(0xff6700));
	}
	
	@Override
	public void gxisdatig() {
		gxisdatigMenuposicijn();
		gxisdatigSelektatObjektn();
		gxisdatigfloatPosicin();
	}
	
	private void gxisdatigMenuposicijn() {
		if(QefObjektj.inventar.armiljn().isEmpty()) {
			return;
		}

		for (int i = 0; i < QefObjektj.inventar.armiljn().size(); i++) {
			final Point puntoInicial = new Point(titolObjektpanel.x + gxeneralMargxen,
					titolObjektpanel.y + titolObjektpanel.height + gxeneralMargxen);

			int idActual = QefObjektj.inventar.armiljn().get(i).idn();

			QefObjektj.inventar.objektn(idActual).setMenuposicin(puntoInicial.x + i * (Konstantj.SPRITEFLANK +
					gxeneralMargxen), puntoInicial.y);
		}
	}
	private void gxisdatigSelektatObjektn() {
		if(!QefObjektj.superfic.muyn().qclickn())
			return;
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(muy.intersects(objektpanel)) {
			if(QefObjektj.inventar.armiljn().isEmpty())
				return;
			for(Objekt nun:QefObjektj.inventar.armiljn()) {
				if(muy.intersects(nun.menuposicin()))
					selektat = nun;
			}
		} else if(muy.intersects(armazhpanel)) {
			if(muy.intersects(armilar) && selektat instanceof Armil) {
				QefObjektj.ludant.vivazharmilarn().setArmil1((Armil) selektat);
				Konstantj.qyangxSpriteFoli = true;
				selektat = null;
			}
		}
	}
	private void gxisdatigfloatPosicin() {
		if(selektat!=null) {
			if(QefObjektj.superfic.muyn().qclick2n()) {
				selektat = null;
				return;
			}
			final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
			selektat.setFloatMenuposicin(muy.x, muy.y);
		}
	}
	
}