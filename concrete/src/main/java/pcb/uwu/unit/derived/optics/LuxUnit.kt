package pcb.uwu.unit.derived.optics;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.scalar.SteradianUnit.STERADIAN;

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
