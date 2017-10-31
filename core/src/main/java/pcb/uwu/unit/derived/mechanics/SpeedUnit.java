package pcb.uwu.unit.derived.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;

public class SpeedUnit extends CompositeUnit {

	// region base constructor

	public SpeedUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit)
				.minor(timeUnit));
	}

	// endregion

	// region derived constructors

	public SpeedUnit(PaceUnit paceUnit) {
		super(new UnitCounter()
				.minor(paceUnit.getUnitCounter()));
	}

	// endregion

}
