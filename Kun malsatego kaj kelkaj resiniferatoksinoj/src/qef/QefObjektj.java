package qef;

import qef.estazhj.vivazhj.Ludant;
import qef.grafikj.Superficdesegn;
import qef.inventar.Inventar;
import qef.map.Map;
import qef.statmayin.Statperant;
import qef.uzantinterfac.Submenu;
import qef.uzantinterfac.map.Malhelec;

public class QefObjektj {//Objektoj de la ludoj

	public static Map map = new Map(1);
	public static Ludant ludant = new Ludant();
	public static Submenu submenu = new Submenu();
	public static Malhelec malhelec = new Malhelec();
	public static Superficdesegn superfic = new Superficdesegn();
	public static Statperant statp = new Statperant();
	public static Inventar inventar = new Inventar();
}