package qef;

import qef.grafikj.Fenestr;
import qef.grafikj.Superficdesegn;
import qef.statmayin.Statperant;

public class Qefperant {
	
	private boolean funkciante;//gxi devas esti volatile kiam mi aldonos alian threads-on
	
	private String titol;
	private int largx, alt;
	
//	private Fenestr fenestr;
	private Superficdesegn superfic;
	private Statperant statp;
	
	public static void main(String[] args) {
		Qefperant qp = new Qefperant("Kun malsatego kaj kelkaj resiniferatoksinoj...", Konstantj.plejfenestrLargx,
			Konstantj.plejfenestrAlt);
		
		qp.ekLudn();
		qp.ekQefBukln();
	}
	
	private Qefperant(final String titol, final int largx, final int alt) {
		this.titol = titol;
		this.largx = largx;
		this.alt = alt;
	}
	
	private void desegn() {
		superfic.desegn(statp);
	}
	
	private void gxisdatig() {
		statp.yangxNunStatn();
		statp.gxisdatig();
		superfic.muyn().gxisdatig();
	}
	
	private void ekLudn() {
		funkciante = true;
		
		definigad();
	}
	
	private void definigad() {
		superfic = new Superficdesegn(largx, alt);
		new Fenestr(titol, superfic);
		statp = new Statperant(superfic.muyn());
	}
	
	private void ekQefBukln() {
		int fpsAkumulita = 0;
		int apsAkumulita = 0;
		
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;
		
		while (funkciante) {
			
			final long inicioBucle = System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			
			while (delta >= 1) {
				gxisdatig();
				apsAkumulita++;
				
				delta--;
			}
			
			desegn();
			fpsAkumulita++;
			
			if ((System.nanoTime() - referenciaContador) > NS_POR_SEGUNDO) {
				//System.out.println(Konstantj.fps);
				Konstantj.qiufps += fpsAkumulita;
				Konstantj.aps = apsAkumulita;
				Konstantj.fps = fpsAkumulita;
				Konstantj.sekundjPasita++;
/*				System.out.println("Promedio de fps po sekundo: " + Konstantj.qiufps/Konstantj.sekundjPasita + ". Sekundoj pasitaj: " +
					Konstantj.sekundjPasita + ". Nuna FPS: " + Konstantj.fpsAkumulita + ".");*/
				apsAkumulita = 0;
				fpsAkumulita = 0;
				referenciaContador = System.nanoTime();
				
			}
			
		}
	}
	
}