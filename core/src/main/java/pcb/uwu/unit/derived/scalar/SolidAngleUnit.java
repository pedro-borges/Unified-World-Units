package pcb.uwu.unit.derived.scalar;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.UnitCounter;

import java.util.function.Function;

public class SolidAngleUnit extends BaseUnit {

	protected SolidAngleUnit() {
		super(0, "sr", "Steradian", "Steradians", Function.identity(), Function.identity());
	}

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return null;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return new UnitCounter();
	}
}