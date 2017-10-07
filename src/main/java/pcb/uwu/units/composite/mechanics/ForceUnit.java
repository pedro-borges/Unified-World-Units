package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.fundamental.MassUnit;

public class ForceUnit extends CompositeUnit {

	public ForceUnit(MassUnit massUnit, AccelerationUnit accelerationUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.minor(accelerationUnit));
	}
}
