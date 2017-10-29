package pcb.uwu.units.composite.termodynamics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.composite.fundamental.AreaUnit;
import pcb.uwu.units.composite.mechanics.ForceUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class PressureUnit extends CompositeUnit {

	// region base constructor

	public PressureUnit(LengthUnit lengthUnit, MassUnit massUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.minor(lengthUnit)
				.minor(timeUnit, 2));
	}

	// endregion

	// region composite constructors

	public PressureUnit(ForceUnit forceUnit, AreaUnit areaUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.minor(areaUnit.getUnitCounter()));
	}

	// endregion

}
