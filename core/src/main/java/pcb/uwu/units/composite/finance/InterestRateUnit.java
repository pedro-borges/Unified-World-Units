package pcb.uwu.units.composite.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.TimeUnit;

public class InterestRateUnit extends CompositeUnit {

	//todo change to frequencyUnit
	public InterestRateUnit(TimeUnit time) {
		super(new UnitCounter()
				.minor(time));
	}
}
