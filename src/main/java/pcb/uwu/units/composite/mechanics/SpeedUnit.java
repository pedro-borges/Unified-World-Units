package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.fundamental.LengthUnit;
import pcb.uwu.units.fundamental.TimeUnit;

public class SpeedUnit extends CompositeUnit {

	public SpeedUnit(LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit)
				.minor(timeUnit));
	}
}
