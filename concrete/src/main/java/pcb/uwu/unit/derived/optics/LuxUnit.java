package pcb.uwu.unit.derived.optics;

import pcb.uwu.units.derived.optics.IlluminanceUnit;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.derived.scalar.SteradianUnit.STERADIAN;

public class LuxUnit extends IlluminanceUnit {

	public static final LuxUnit LUX = new LuxUnit();

	public LuxUnit() {
		super(CANDELA, STERADIAN, METER);
	}

	@Override
	public String getSymbol() {
		return "lx";
	}

	@Override
	public String getSingularName() {
		return "lux";
	}

	@Override
	public String getPluralName() {
		return "lux";
	}
}
