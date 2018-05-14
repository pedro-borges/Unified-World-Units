package pcb.uwu.unit.derived.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.finance.MoneyUnit;

public class DebtUnit extends CompositeUnit {

	public DebtUnit(MoneyUnit moneyUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(moneyUnit)
				.major(timeUnit));
	}
}
