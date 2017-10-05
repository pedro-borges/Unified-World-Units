package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.Unit;
import pcb.uwu.units.fundamental.MassUnit;
import pcb.uwu.utils.ObjectCounter;

public class ForceUnit extends CompositeUnit {

	public ForceUnit(MassUnit massUnit, AccelerationUnit accelerationUnit) {
		super(new ObjectCounter<Unit>()
				.major(massUnit)
				.minor(accelerationUnit));
	}

	public ForceUnit(AccelerationUnit accelerationUnit, MassUnit massUnit) {
		super(new ObjectCounter<Unit>()
				.major(massUnit)
				.minor(accelerationUnit));
	}
}
