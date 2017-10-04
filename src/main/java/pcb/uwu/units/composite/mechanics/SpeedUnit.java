package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.ComposedUnit;
import pcb.uwu.core.Unit;
import pcb.uwu.units.fundamental.LengthUnit;
import pcb.uwu.units.fundamental.TimeUnit;
import pcb.uwu.utils.ObjectCounter;

public class SpeedUnit
		extends ComposedUnit
		implements Unit {

	public SpeedUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new ObjectCounter<Unit>()
				.major(lengthUnit)
				.minor(timeUnit));
	}
}
