package pcb.uwu.unit.derived.scalar;

import pcb.uwu.units.derived.scalar.AngleUnit;

public class RadianUnit extends AngleUnit {

	public static final RadianUnit RADIAN = new RadianUnit();

	public RadianUnit() {
		super();
	}

	@Override
	public String getSymbol() {
		return "rad";
	}

	@Override
	public String getSingularName() {
		return "radian";
	}

	@Override
	public String getPluralName() {
		return "radians";
	}
}
