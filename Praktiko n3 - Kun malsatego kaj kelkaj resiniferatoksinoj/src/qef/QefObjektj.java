package qef;

import qef.estazhj.vivazhj.Ludant;
import qef.map.Map;
import qef.uzantinterfac.Submenu;
import qef.uzantinterfac.map.Malhelec;

public class QefObjektj {//Objektoj de la ludoj
	
	public static Map map = new Map(0);
	public static Ludant ludant = new Ludant(map);
	public static Submenu submenu = new Submenu();
	public static Malhelec malhelec = new Malhelec();
}