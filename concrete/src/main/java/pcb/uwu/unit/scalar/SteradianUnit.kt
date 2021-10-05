package pcb.uwu.unit.scalar;

import static pcb.uwu.unit.base.RadianUnit.RADIAN;

public class SteradianUnit extends SolidAngleUnit {

	public static final SteradianUnit STERADIAN = new SteradianUnit();

	public SteradianUnit() {
		super(RADIAN, RADIAN);
	}

	@Override
	public String getSymbol() {
		return "sr";
	}

	@Override
	public String getSingularName() {
		return "steradian";
	}

	@Override
	public String getPluralName() {
		return "steradians";
	}
}
