package pcb.uwu.unit.derived.optics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.LuminousIntensityUnit;

public class LuminanceUnit extends CompositeUnit {

	// region base constructor

	public LuminanceUnit(LuminousIntensityUnit luminousIntensityUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(luminousIntensityUnit.getUnitCounter())
				.minor(lengthUnit, 2));
	}

	// endregion

}
