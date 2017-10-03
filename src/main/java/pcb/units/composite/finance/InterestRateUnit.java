package pcb.units.composite.finance;

import pcb.units.base.ComposedUnit;
import pcb.units.base.Unit;
import pcb.units.dimensions.time.TimeUnit;
import pcb.units.utils.ObjectCounter;

public class InterestRateUnit
		extends ComposedUnit {

	public InterestRateUnit(TimeUnit time) {
		super(new ObjectCounter<Unit>()
				.minor(time));
	}
}
