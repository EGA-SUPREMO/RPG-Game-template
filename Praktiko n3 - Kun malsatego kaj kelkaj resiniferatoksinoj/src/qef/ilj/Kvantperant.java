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

    public static double kakulDistancn(final int x1, final int y1, final int x2, final int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
