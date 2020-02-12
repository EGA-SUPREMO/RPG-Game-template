/** This program is free software: you can redistribute it and/or modify
  *  it under the terms of the GNU General Public License as published by
  *  the Free Software Foundation, either version 3 of the License, or
  *  (at your option) any later version.
  *
  *  This program is distributed in the hope that it will be useful,
  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  *  GNU General Public License for more details.
  *
  *  You should have received a copy of the GNU General Public License
  *  along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

package qef;

import qef.grafikj.Fenestr;
import qef.son.Son;

public class Qefperant {
	
	private boolean funkciante;//gxi devas esti volatile kiam mi aldonos alian threads-on
	
	private String titol;
	
//	private Fenestr fenestr;
	private Son fonmuzik;
	
	public static void main(String[] args) {
		//Nur por OpenGL en Mac/Linux
		//System.setProperty("sun.java2d.opengl", "True");
		
		/*
		 * Para Directx en Windows
		 * System.setProperty("sun.java2d.d3d", "True");
		 * System.setProperty("sun.java2d.ddforcevram", "True");
		 */
		
		//System.setProperty("sun.java2d.transaccel", "True");
		Qefperant qp = new Qefperant("Kun malsatego kaj kelkaj resiniferatoksinoj...", Konstantj.plejfenestrLargx,
			Konstantj.plejfenestrAlt);
		
		qp.ekLudn();
		qp.ekQefBukln();
	}
	
	private Qefperant(final String titolo, final int largx, final int alt) {
		titol = titolo;
		Konstantj.nunlargxFenestr = largx;
		Konstantj.nunaltFenestr = alt;
	}
	
	private void desegn() {
		QefObjektj.superfic.desegn(QefObjektj.statp);
	}
	
	private void gxisdatig() {
		QefObjektj.statp.yangxNunStatn();
		QefObjektj.statp.gxisdatig();
		QefObjektj.superfic.muyn().gxisdatig();
	}
	
	private void ekLudn() {
		funkciante = true;
		
		definigad();
		fonmuzik.loop();
	}
	
	private void definigad() {
		fonmuzik = new Son(Konstantj.ITENER_SONJ_LUDANT + "pom.wav", 0);
		new Fenestr(titol);
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
				Konstantj.qiufps += fpsAkumulita;
				Konstantj.aps = apsAkumulita;
				Konstantj.fps = fpsAkumulita;
				Konstantj.sekundjPasita++;
				apsAkumulita = 0;
				fpsAkumulita = 0;
				referenciaContador = System.nanoTime();
				
			}
			
		}
	}
	
}