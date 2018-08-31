package qef.inventar.armil;

import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import qef.Konstantj;
import qef.estazhj.vivazhj.Vivazh;
import qef.inventar.Objekt;
import qef.son.Son;
import qef.sprite.SpriteFoli;

public abstract class Armil extends Objekt {
	
	public static SpriteFoli ArmilSpriteFoli = new SpriteFoli(Konstantj.ITENER_OBJEKT_ARMIL + 0 + ".png",
			Konstantj.SPRITEFLANK, Transparency.TRANSLUCENT);
	
	protected int plejatak;
	protected int mlplejatak;
	public Son sonidoDisparo;
    protected boolean automatica;
    protected boolean penetrante;
    protected double ataquesPorSegundo;
    protected int actualizacionesParaSiguienteAtaque;
	
	public Armil(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo);

		plejatak = plejatako;
		mlplejatak = mlplejatako;
		
	}
	
	@Override
	public BufferedImage spriten() {
		return ArmilSpriteFoli.spritejn(Konstantj.KVANT_KONSUMEBL_OBJEKT - id);
	}

	public abstract ArrayList<Rectangle> atingec(Vivazh vivazh);
	
	public void gxisdatig() {
        if (actualizacionesParaSiguienteAtaque > 0) {
            actualizacionesParaSiguienteAtaque--;
        }
	}
	
	public void atacar(final ArrayList<Vivazh> enemigos) {
		
		if (actualizacionesParaSiguienteAtaque > 0)  {
			return;
		}
		actualizacionesParaSiguienteAtaque = (int) (ataquesPorSegundo * 60);
		
		sonidoDisparo.play();
		
		if (enemigos.isEmpty()) {
			return;
		}
	
		float ataqueActual = obtenerAtaqueMedio();
	
		for (Vivazh enemigo : enemigos) {
			enemigo.perderVida(ataqueActual);
		}
	}
	
	private float obtenerAtaqueMedio() {
        return new Random().nextInt(plejatak - mlplejatak) + mlplejatak;
	}
}