package pcb.uwu.units.composite.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.Unit;
import pcb.uwu.units.fundamental.TimeUnit;
import pcb.uwu.utils.ObjectCounter;

public class InterestRateUnit extends CompositeUnit {

	public InterestRateUnit(TimeUnit time) {
		super(new ObjectCounter<Unit>()
				.minor(time));
	}
}
