package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class AccelerationUnit extends CompositeUnit {

	// region base constructor

	public AccelerationUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit)
				.minor(timeUnit, 2));
	}

	// endregion

	// region composite constructors

	public AccelerationUnit(SpeedUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit.getUnitCounter())
				.minor(timeUnit));
	}

	// endregion

}
