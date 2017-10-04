package pcb.uwu.units.composite.finance;

import pcb.uwu.core.ComposedUnit;
import pcb.uwu.core.Unit;
import pcb.uwu.units.fundamental.TimeUnit;
import pcb.uwu.utils.ObjectCounter;

public class InterestRateUnit
		extends ComposedUnit {

	public InterestRateUnit(TimeUnit time) {
		super(new ObjectCounter<Unit>()
				.minor(time));
	}
}
