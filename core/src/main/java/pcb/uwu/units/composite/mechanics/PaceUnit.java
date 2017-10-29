package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class PaceUnit extends CompositeUnit {

	// region base constructor

	public PaceUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(timeUnit)
				.minor(lengthUnit));
	}

	// endregion

	// region composite constructors

	public PaceUnit(SpeedUnit speedUnit) {
		super(new UnitCounter()
				.minor(speedUnit.getUnitCounter()));
	}

	// endregion
}
