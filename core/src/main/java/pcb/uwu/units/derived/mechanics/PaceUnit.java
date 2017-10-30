package pcb.uwu.units.derived.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.LengthUnit;
import pcb.uwu.units.base.TimeUnit;

public class PaceUnit extends CompositeUnit {

	// region base constructor

	public PaceUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(timeUnit)
				.minor(lengthUnit));
	}

	// endregion

	// region derived constructors

	public PaceUnit(SpeedUnit speedUnit) {
		super(new UnitCounter()
				.minor(speedUnit.getUnitCounter()));
	}

	// endregion
}
