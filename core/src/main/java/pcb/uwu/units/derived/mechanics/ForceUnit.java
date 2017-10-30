package pcb.uwu.units.derived.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.LengthUnit;
import pcb.uwu.units.base.MassUnit;
import pcb.uwu.units.base.TimeUnit;

public class ForceUnit extends CompositeUnit {

	// region base constructor

	public ForceUnit(MassUnit mass, LengthUnit length, TimeUnit time) {
		super(new UnitCounter()
				.major(mass)
				.major(length)
				.minor(time, 2));
	}

	// endregion

	// region derived constructors

	public ForceUnit(MassUnit massUnit, AccelerationUnit accelerationUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(accelerationUnit.getUnitCounter()));
	}

	// endregion

}
