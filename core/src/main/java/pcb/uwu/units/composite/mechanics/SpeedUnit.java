package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class SpeedUnit extends CompositeUnit {

	// region base constructor

	public SpeedUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit)
				.minor(timeUnit));
	}

	// endregion

	// region composite constructors

	public SpeedUnit(PaceUnit paceUnit) {
		super(new UnitCounter()
				.minor(paceUnit.getUnitCounter()));
	}

	// endregion

}
