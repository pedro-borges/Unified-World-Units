package pcb.uwu.units.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.TimeUnit;

public class MoneyRateUnit extends CompositeUnit {

	public MoneyRateUnit(MoneyUnit money, TimeUnit time) {
		super(new UnitCounter()
				.major(money)
				.minor(time));
	}

	public MoneyRateUnit(MoneyUnit money, InterestRateUnit interestRateUnit) {
		super(new UnitCounter()
				.major(money)
				.major(interestRateUnit.getUnitCounter()));
	}
}
