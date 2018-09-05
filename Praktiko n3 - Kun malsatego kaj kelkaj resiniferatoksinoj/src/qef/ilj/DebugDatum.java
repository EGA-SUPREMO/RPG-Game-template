package qef.ilj;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Iterator;

public class DebugDatum {
	
	private static ArrayDeque<String> datumjToDesegn = new ArrayDeque<>(25);
	private static final int ALT_LITER = 10;
	
	public static void addDatumn(final String datum) {
		datumjToDesegn.add(datum);
	}
	
	public static void malplenigDatumjn() {
		datumjToDesegn.clear();
	}
	
	public static void desegn() {
		
		Iterator<String> it = datumjToDesegn.iterator();
		
		int counter = 3;//jam estas desegnita la fps kaj aps
		
		while(it.hasNext()) {
			counter++;
			
			DebugDesegn.desegnString(it.next(), 10, counter * ALT_LITER, Color.BLUE);
		}
		
	}
	
}