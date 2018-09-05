package qef.kontrolj;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import qef.Konstantj;
import qef.QefObjektj;
import qef.uzantinterfac.Text;

public class Klavar extends KeyAdapter {

	public Klav supr = new Klav();
	public Klav sub = new Klav();
	public Klav dextr = new Klav();
	public Klav mldextr = new Klav();
	public boolean kuri = false;
	public boolean debug = false;
	public boolean aktivInventari = false;
	public boolean qkolekt = false;
	public boolean qatak = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case Konstantj.SUPR:
				supr.puls();
				break;
			case Konstantj.SUB:
				sub.puls();
				break;
			case Konstantj.DEXTR:
				dextr.puls();
				break;
			case Konstantj.MLDEXTR:
				mldextr.puls();
				break;
			case Konstantj.KURI:
				kuri = true;
				break;
			case Konstantj.DEBUG:
				debug = !debug;
				break;
			case Konstantj.AKTIV_INVENTARI:
				aktivInventari = !aktivInventari;
				break;
			case Konstantj.QKOLEKT:
				qkolekt = true;
				break;
			case Konstantj.ATAKI:
				qatak = true;
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case Konstantj.SUPR:
				supr.mlpuls();
				break;
			case Konstantj.SUB:
				sub.mlpuls();
				break;
			case Konstantj.DEXTR:
				dextr.mlpuls();
				break;
			case Konstantj.MLDEXTR:
				mldextr.mlpuls();
				break;
			case Konstantj.KURI:
				kuri = false;
				break;
			case Konstantj.ELIRI:
				elir();
				break;
			case Konstantj.REKOMENCI:
				QefObjektj.ludant.setX(480);
				QefObjektj.ludant.setY(280);
				Text.RES.mlnuligKvantn();
				break;
			case Konstantj.QKOLEKT:
				qkolekt = false;
				break;
			case Konstantj.ATAKI:
				qatak = false;
				break;
		}
	}
	
	public void elir() {
		System.exit(0);
	}
	
}