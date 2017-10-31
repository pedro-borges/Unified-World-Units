package pcb.uwu.unit.derived.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;

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
