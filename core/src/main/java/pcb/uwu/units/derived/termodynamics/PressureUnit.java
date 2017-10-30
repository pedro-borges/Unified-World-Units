package pcb.uwu.units.derived.termodynamics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.LengthUnit;
import pcb.uwu.units.base.MassUnit;
import pcb.uwu.units.base.TimeUnit;
import pcb.uwu.units.derived.fundamental.AreaUnit;
import pcb.uwu.units.derived.mechanics.ForceUnit;

public class PressureUnit extends CompositeUnit {

	// region base constructor

	public PressureUnit(LengthUnit lengthUnit, MassUnit massUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.minor(lengthUnit)
				.minor(timeUnit, 2));
	}

	// endregion

	// region derived constructors

	public PressureUnit(ForceUnit forceUnit, AreaUnit areaUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.minor(areaUnit.getUnitCounter()));
	}

	// endregion

}
