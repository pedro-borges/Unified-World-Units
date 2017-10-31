package pcb.uwu.unit.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.TimeUnit;

public class RentUnit extends CompositeUnit {

	public RentUnit(MoneyUnit money, TimeUnit time) {
		super(new UnitCounter()
				.major(money)
				.minor(time));
	}

	public RentUnit(MoneyUnit money, InterestRateUnit interestRateUnit) {
		super(new UnitCounter()
				.major(money)
				.major(interestRateUnit.getUnitCounter()));
	}
}
