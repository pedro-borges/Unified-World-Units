package pcb.uwu.unit.derived.optics;

import pcb.uwu.units.derived.optics.LuminousEnergyUnit;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.scalar.SteradianUnit.STERADIAN;

public class TalbotUnit extends LuminousEnergyUnit {

	public static final TalbotUnit TALBOT = new TalbotUnit();

	public TalbotUnit() {
		super(CANDELA, STERADIAN, SECOND);
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
