package qef.son;

import javax.sound.sampled.Clip;

import qef.Konstantj;
import qef.ilj.YargxilAzhj;

public class Son {
	
	final private Clip son;
	
	public Son(final String itener, final int mlplivolum) {
		son = YargxilAzhj.yargxSonn(Konstantj.ITENER_SONJ + itener, mlplivolum);
	}

	public void play() {
		son.stop();
		son.flush();
		son.setMicrosecondPosition(0);
		son.start();
	}
	public void loop() {
		son.stop();
		son.flush();
		son.setMicrosecondPosition(0);
		son.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public long longsonn() {
		return son.getMicrosecondLength();
	}
	
}