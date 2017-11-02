package pcb.uwu.unit.derived.termodynamics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.area.AreaUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;

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
