package pcb.uwu.unit.derived.optics;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;

public class NitUnit extends LuminanceUnit {

	public static final NitUnit NIT = new NitUnit();

	public NitUnit() {
		super(CANDELA, SQUARE_METER);
	}

	@Override
	public String getSymbol() {
		return "nit";
	}

	@Override
	public String getSingularName() {
		return "nit";
	}

	@Override
	public String getPluralName() {
		return "nits";
	}
}
