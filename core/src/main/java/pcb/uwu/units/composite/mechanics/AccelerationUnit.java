package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.TimeUnit;

public class AccelerationUnit extends CompositeUnit {

	public AccelerationUnit(SpeedUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(lengthUnit.getUnitCounter())
				.minor(timeUnit));
	}
}
