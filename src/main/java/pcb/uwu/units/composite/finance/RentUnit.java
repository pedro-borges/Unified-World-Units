package pcb.uwu.units.composite.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.Unit;
import pcb.uwu.units.fundamental.MoneyUnit;
import pcb.uwu.units.fundamental.TimeUnit;
import pcb.uwu.utils.ObjectCounter;

public class RentUnit extends CompositeUnit {

	public RentUnit(MoneyUnit money, TimeUnit time) {
		super(new ObjectCounter<Unit>()
				.major(money)
				.minor(time));
	}

	public RentUnit(MoneyUnit money, InterestRateUnit interestRateUnit) {
		super(new ObjectCounter<Unit>()
				.major(money)
				.major(interestRateUnit));
	}
}
