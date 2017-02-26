package qef.uzantinterfac;

import qef.Konstantj;
import qef.QefObjektj;

public enum Text {
	VIV(QefObjektj.ludant.vivn(), 100), RES(QefObjektj.ludant.resistencn(), Konstantj.plejResistenc),
	EXP(QefObjektj.ludant.experiencn(), 100), ATK(QefObjektj.ludant.damagxn(), 100);
	
	private Integer kvant;
	private Integer plejkvant;
	
	private Text(Integer kvant, Integer plejkvant) {
		this.kvant = kvant;
		this.plejkvant = plejkvant;
	}
	
	public int kvantn() {
		return kvant;
	}
	public int plejkvantn() {
		return plejkvant;
	}
	
}