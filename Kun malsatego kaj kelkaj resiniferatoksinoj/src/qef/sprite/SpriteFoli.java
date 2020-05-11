package qef.sprite;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import qef.ilj.YargxilAzhj;

public class SpriteFoli {
	
	private final int largxEnPixel, altEnPixel;
	private final int largxEnSprite, altEnSprite;
	
	private final int spriteLargx, spriteAlt;
	
	private final BufferedImage[] spritej;
	
	public SpriteFoli(final String itener, final Dimension dimension, final int diafan) {
		
		BufferedImage i;
		
		i = YargxilAzhj.yargxBildn(itener, diafan);
		
		largxEnPixel = i.getWidth();
		altEnPixel = i.getHeight();
		
		this.spriteLargx = dimension.width;
		this.spriteAlt = dimension.height;

		largxEnSprite = largxEnPixel / spriteLargx;
		altEnSprite = altEnPixel / spriteAlt;
		
		spritej = new BufferedImage[largxEnSprite * altEnSprite];
		
		plenSpriten(i);
		
	}
	
	public SpriteFoli(final String itener, final int spriteGrandec, final int diafan) {
		
		BufferedImage i;
		
		i = YargxilAzhj.yargxBildn(itener, diafan);
		
		largxEnPixel = i.getWidth();
		altEnPixel = i.getHeight();
		
		this.spriteLargx = spriteGrandec;
		this.spriteAlt = spriteGrandec;

		largxEnSprite = largxEnPixel / spriteLargx;
		altEnSprite = altEnPixel / spriteAlt;
		
		spritej = new BufferedImage[largxEnSprite * altEnSprite];
		
		plenSpriten(i);
		
	}
	
	public SpriteFoli(final String itener, final int spriteGrandec,  final int diafan, final int verSpriteGrandec) {
		
		BufferedImage i;
		
		i = YargxilAzhj.yargxBildn(itener, diafan, verSpriteGrandec/spriteGrandec);
		
		largxEnPixel = i.getWidth(null);
		altEnPixel = i.getHeight(null);
		
		this.spriteLargx = spriteGrandec;
		this.spriteAlt = spriteGrandec;

		largxEnSprite = largxEnPixel / spriteLargx;
		altEnSprite = altEnPixel / spriteAlt;
		
		spritej = new BufferedImage[largxEnSprite * altEnSprite];
		
		plenSpriten(i);
		
	}

	private void plenSpriten(final BufferedImage i) {
		for(int y = 0; y < altEnSprite; y++)
			for(int x = 0; x < largxEnSprite; x++)
				spritej[x + y * largxEnSprite] = i.getSubimage(x * spriteLargx, y * spriteAlt, spriteLargx, spriteAlt);
	}

	public BufferedImage[] spritejn() {
		return spritej;
	}
	public BufferedImage spritejn(final int i) {
		return spritej[i];
	}
	
	public BufferedImage spritejn(final int x, final int y) {
		return spritej[x + y * largxEnSprite];
	}
	
}