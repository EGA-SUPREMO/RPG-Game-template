package qef.ilj;

import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
//import java.awt.geom.AffineTransformOp;
//import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Bildperant {
	
/*	private AffineTransform at;
	private int alturaImagen;
	private int anchoImagen;
	private double grados;
	
	public Bildperant(int alturaImagen, int anchuraImagen) {
		at = new AffineTransform();
		this.alturaImagen = alturaImagen;
		this.anchoImagen = anchuraImagen;
	}
	
	public void rotate(double grados) {
		this.grados = grados;
		at.rotate(grados, anchoImagen / 2, alturaImagen / 2);
	}*/
	
/*	public void findTranslation() {
		Point2D p2din, p2dout;
		p2din = hallarPtoATraslacion();
		p2dout = at.transform(p2din, null);
		double ytrans = p2dout.getY();
		
		p2din = hallarPtoBTraslacion();
		p2dout = at.transform(p2din, null);
		double xtrans = p2dout.getX();
		AffineTransform tat = new AffineTransform();
		
		tat.translate(-xtrans, -ytrans);
		at.preConcatenate(tat);
	}
	
	private Point2D hallarPtoATraslacion() {
		Point2D p2din;
		if (grados >= 0 && grados <= 90) {
			p2din = new Point2D.Double(0.0, 0.0);
		} else if (grados > 90 && grados <= 180) {
			p2din = new Point2D.Double(0.0, alturaImagen);
		} else if (grados > 180 && grados <= 270) {
			p2din = new Point2D.Double(anchoImagen, alturaImagen);
		} else {
			p2din = new Point2D.Double(anchoImagen, 0.0);
		}
		return p2din;
	}
	
	private Point2D hallarPtoBTraslacion() {
		Point2D p2din;
		if (grados >= 0 && grados <= 90) {
			p2din = new Point2D.Double(0.0, alturaImagen);
		} else if (grados > 90 && grados <= 180) {
			p2din = new Point2D.Double(anchoImagen, alturaImagen);
		} else if (grados > 180 && grados <= 270) {
			p2din = new Point2D.Double(anchoImagen, 0.0);
		} else {
			p2din = new Point2D.Double(0.0, 0.0);
		}
		return p2din;
	}*/
/*	
	public AffineTransform getTransform() {
		return at;
	}*/
	
	public static BufferedImage volvBildn(final BufferedImage devenBild, final double radian) {//devenBildradian
/*		BufferedImage destinationImage = new BufferedImage(0, 0, 0);
		System.out.println(origen.toString());
		Bildperant imTransform = new Bildperant(origen.getHeight(), origen.getWidth());
		imTransform.rotate(grados);
		imTransform.findTranslation();
		//AffineTransformOp ato = new AffineTransformOp(imTransform.getTransform(), AffineTransformOp.TYPE_BILINEAR);
		//destinationImage = ato.createCompatibleDestImage(origen, origen.getColorModel());
		//return ato.filter(origen, destinationImage);*/
//		Bildperant imTransform = new Bildperant(origen.getHeight(), origen.getWidth());
//		imTransform.rotate(grados);
		//imTransform.findTranslation();
		AffineTransform rotad = new AffineTransform();
		rotad.rotate(radian, devenBild.getWidth() / 2, devenBild.getHeight() / 2);
		
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().
				createCompatibleImage(devenBild.getWidth(), devenBild.getHeight(), Transparency.TRANSLUCENT);
		
		Graphics g = bild.getGraphics();
		((Graphics2D)g).drawImage(devenBild, rotad, null);
		g.dispose();
		
		return bild;
	}
}