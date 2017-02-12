package qef.statmayin.statj.lud;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDatum;
import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Submenu;

public class Ludperant implements Statlud {
	
	@Override
	public void gxisdatig() {
		QefObjektj.ludant.gxisdatig();
		QefObjektj.map.gxisdatig();
	}
	
	@Override
	public void desegn() {
		
		QefObjektj.map.desegn();
		QefObjektj.ludant.desegn();

		DebugDatum.addDatumn("X: " + QefObjektj.ludant.xn());
		DebugDatum.addDatumn("Y: " + QefObjektj.ludant.yn());
		DebugDatum.addDatumn("Sekundoj pasitaj: " + Konstantj.sekundjPasita);
		try {
		DebugDatum.addDatumn("Promedio de fps po sekundo: " + Konstantj.qiufps/Konstantj.sekundjPasita);
		}catch(ArithmeticException e) {/*e.printStackTrace();*/}
		DebugDatum.addDatumn("Res: " + QefObjektj.ludant.resistencn());
		DebugDatum.addDatumn("Restarigado: " + QefObjektj.ludant.restarigadn());
		DebugDatum.addDatumn("Faktoro X: " + Konstantj.faktorX);
		DebugDatum.addDatumn("Faktoro Y: " + Konstantj.faktorY);
		DebugDatum.addDatumn("Venonta mapo: " + QefObjektj.ludant.mapn().venontMapn());
		DebugDatum.addDatumn("Komenca posicio X: " + QefObjektj.ludant.mapn().xLudantn());
		DebugDatum.addDatumn("Komenca posicio Y: " + QefObjektj.ludant.mapn().yLudantn());
		DebugDatum.addDatumn("OPF: " + DebugDesegn.objektjDesegnitan());
		
		//Submenu.desegnBarn(20, QefObjektj.ludant.resistencn(), Konstantj.plejResistenc, 5);
		
	}
	
}
