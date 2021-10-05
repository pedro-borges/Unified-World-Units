package pcb.uwu.unit.derived.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;

public class AccelerationUnit extends CompositeUnit {

	// region base constructor

	public AccelerationUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit)
				.minor(timeUnit, 2));
	}

	// endregion

	// region derived constructors

	public AccelerationUnit(SpeedUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit.getUnitCounter())
				.minor(timeUnit));
	}

	// endregion

}
