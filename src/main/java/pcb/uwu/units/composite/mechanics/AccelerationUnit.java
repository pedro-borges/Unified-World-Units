package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.Unit;
import pcb.uwu.units.fundamental.TimeUnit;
import pcb.uwu.utils.ObjectCounter;

public class AccelerationUnit
		extends CompositeUnit
		implements Unit {

	public AccelerationUnit(SpeedUnit lengthUnit, TimeUnit timeUnit) {
		super(new ObjectCounter<Unit>()
				.major(lengthUnit)
				.minor(timeUnit));
	}
}
