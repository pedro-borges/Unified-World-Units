package pcb.uwu.unit.derived.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.finance.CurrencyUnit;

public class DebtUnit extends CompositeUnit {

	public DebtUnit(CurrencyUnit currencyUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(currencyUnit)
				.major(timeUnit));
	}
}
