package pcb.units.dimensions.fundamental.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.dimensions.fundamental.TimeUnit;

import java.math.BigDecimal;

public abstract class Time extends AbstractUnitAmount<BigDecimal, TimeUnit, Time> {
	public Time(
			Amount<BigDecimal> amount,
			TimeUnit unit) {

		super(amount, unit);
	}
}
