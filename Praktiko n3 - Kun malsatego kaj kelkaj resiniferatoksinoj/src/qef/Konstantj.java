package qef;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import qef.ilj.YargxilAzhj;

public abstract class Konstantj {
	
	public static final int SPRITELARGX = 32;
	public static final int SPRITEALT = 32;
	
	public static int plejRestarigad = 150;
	public static int plejResistenc = 750;

	public static int ludLargx = 640;
	public static int ludAlt = 360;
	
	public static int plejfenestrLargx = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int plejfenestrAlt = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static double faktorX = (double) plejfenestrLargx / (double) ludLargx;
	public static double faktorY = (double) plejfenestrAlt / (double) ludAlt;
	
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
	
	public static int qiufps = 0, fps = 0, aps = 0, sekundjPasita = 0;
	
	public final static String SUFIX_MAP = ".egam";
	public final static String ITENER_MAP = "/maps/";
	public final static String ITENER_LUDANT = "/entities/player_";

	public final static Font KUTIM_FONT = YargxilAzhj.yargxFontn("/Arvin Regular.ttf");
	
	public final static Color ANTAWDEFINIT_KOLOR = Color.BLUE;
	
}