package qef;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import qef.ilj.YargxilAzhj;

public abstract class Konstantj {
	
	public static final int SPRITEFLANK = 32;
	public static final int SPRITELARGX = 32;
	public static final int SPRITEALT = 32;
	
	public static final int KVANT_KONSUMEBL_OBJEKT = 500;
	
	public static int plejRestarigad = 150;
	public static int plejResistenc = 750;
	

	public static int ludLargx = 640;
	public static int ludAlt = 360;
	
	public final static int altSubmenu = 64;//La alto de la submenu
	
	public static int plejfenestrLargx = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int plejfenestrAlt = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static int nunlargxFenestr = plejfenestrLargx, nunaltFenestr = plejfenestrAlt;
	
	public static double faktorX = ((int) ((double) plejfenestrLargx/(double) ludLargx*10d))/10d;
//	public static double faktorY = Double.parseDouble(String.format("%.1f", (double) plejfenestrAlt/(double) ludAlt));
	public static double faktorY = ((int) ((double) plejfenestrAlt/(double) ludAlt*10d))/10d;
//	public static double faktorY = 1;
//	public static double faktorX = 1;
	
	public static int duonLudLargx = ludLargx>>1;
	public static int duonLudAlt = ludAlt>>1;

	public static int altCentr = duonLudAlt - (SPRITEALT >> 1);
	public static int largxCentr = duonLudLargx - (SPRITELARGX >> 1);
	
	public final static int nombroKlablj = 256;
	
	public final static int SUPR = KeyEvent.VK_W;
	public final static int SUB = KeyEvent.VK_S;
	public final static int MLDEXTR = KeyEvent.VK_A;
	public final static int DEXTR = KeyEvent.VK_D;
	public final static int KURI = KeyEvent.VK_SHIFT;
	public final static int ELIRI = KeyEvent.VK_ESCAPE;
	public final static int REKOMENCI = KeyEvent.VK_R;
	public final static int DEBUG = KeyEvent.VK_F1;
	public final static int AKTIV_INVENTARI = KeyEvent.VK_E;
	public final static int QKOLEKTE = KeyEvent.VK_C;
	
	public static int qiufps = 0, fps = 0, aps = 0, sekundjPasita = 0;
	public static boolean qyangxSpriteFoli = false;
	
	public final static String SUFIX_MAP = ".egam";
	public final static String ITENER_MAP = "/maps/";
	public final static String ITENER_TILESET_MAP = "/blocks/";

	public final static String ITENER_VIVAZH = "/entities/";
	public final static String ITENER_LUDANT = ITENER_VIVAZH + "player_";
	public final static String ITENER_MALAMIK = ITENER_VIVAZH + "enemy_";
	public final static String ITENER_ZOMBI = ITENER_MALAMIK + "zombie_";

	public final static String ITENER_OBJEKTJ = "/objects/";
	public final static String ITENER_OBJEKT_ARMIL = ITENER_OBJEKTJ + "weapons/";
	
	public final static String ITENER_OBJEKT_OBJEKTAR = ITENER_OBJEKTJ + "sack.png";

	public final static Font KUTIM_FONT = YargxilAzhj.yargxFontn("/Arvin Regular.ttf");
	
	public final static Color ANTAWDEFINIT_KOLOR = Color.BLUE;
	
	public final static Color KOLOR_SUPR_BANNER = Color.CYAN;
	public final static Color KOLOR_SUB_BANNER = Color.CYAN.darker();
	public final static Color FONKOLOR = Color.WHITE;
	
	public final static Color AKTIV_ETIKED_BOTON_KOLOR = KOLOR_SUB_BANNER.darker();
	
}