package qef.statmayin.statj.lud;

import qef.QefObjektj;
import qef.statmayin.Statlud;

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
		
		QefObjektj.malhelec.desegn();
		
		QefObjektj.submenu.desegn();
		
	}
	
}
