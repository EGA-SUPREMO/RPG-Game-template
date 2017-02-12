package qef.ilj;

import qef.Konstantj;
import qef.QefObjektj;

public class Kvantperant {

	public static double koordenadXalPosici(final double koordenad) {
		return koordenad - QefObjektj.ludant.xn() + Konstantj.largxCentr;
	}
	
	public static double koordenadYalPosici(final double koordenad) {
		return koordenad - QefObjektj.ludant.yn() + Konstantj.altCentr;
	}
	
}
