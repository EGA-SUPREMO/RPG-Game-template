package qef.uzantinterfac;

import qef.Konstantj;
import qef.QefObjektj;

public enum Text {
	VIV(QefObjektj.ludant.vivn(), 100), RES(Konstantj.plejResistenc, Konstantj.plejResistenc),
	EXP(QefObjektj.ludant.experiencn(), 100), ATK(QefObjektj.ludant.damagxn(), 100);
	
	private Integer kvant;
	private Integer plejkvant;
	
	private Text(Integer kvant, Integer plejkvant) {
		this.kvant = kvant;
		this.plejkvant = plejkvant;
	}
	public void pliigKvantn() {
		kvant++;
	}
	public void mlpliigKvantn() {
		kvant--;
	}
	public void nuligKvantn() {
		kvant = 0;
	}
	public void mlnuligKvantn() {
		kvant = plejkvant;
	}
	public int kvantn() {
		return kvant;
	}
	public int plejkvantn() {
		return plejkvant;
	}
	
}