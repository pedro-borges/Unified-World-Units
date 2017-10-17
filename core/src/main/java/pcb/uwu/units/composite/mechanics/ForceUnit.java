package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class ForceUnit extends CompositeUnit {

	public ForceUnit(MassUnit mass, LengthUnit length, TimeUnit time1, TimeUnit time2) {
		super(new UnitCounter()
				.major(mass)
				.major(length)
				.minor(time1)
				.minor(time2));
	}

	public ForceUnit(MassUnit massUnit, AccelerationUnit accelerationUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(accelerationUnit.getUnitCounter()));
	}
}
