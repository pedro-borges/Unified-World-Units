package pcb.uwu.unit.derived.optics;

import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;

public class TalbotUnit extends LuminousEnergyUnit {

	public static final TalbotUnit TALBOT = new TalbotUnit();

	public TalbotUnit() {
		super(LUMEN, SECOND);
	}

	@Override
	public String getSymbol() {
		return "T";
	}

	@Override
	public String getSingularName() {
		return "talbot";
	}

	@Override
	public String getPluralName() {
		return "talbots";
	}
}
