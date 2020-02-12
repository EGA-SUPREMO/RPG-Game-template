package qef.kontrolj;

public class Klav {
	
	private boolean pulsita = false;
	private long lastPulsad = System.nanoTime();
	
	public void puls() {
		pulsita = true;
		lastPulsad = System.nanoTime();
	}
	
	public void mlpuls() {
		pulsita = false;
	}
	
	public boolean pulsitan() {
		return pulsita;
	}
	public long lastPulsadn() {
		return lastPulsad;
	}
	
}