package pcb.units.dimensions.fundamental.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.Unit;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.fundamental.TimeUnit;

import java.math.BigDecimal;
import java.util.function.Function;

public abstract class Time extends AbstractUnitAmount<BigDecimal, TimeUnit, Time> {
	public Time(
			Amount<BigDecimal> amount,
			Unit<BigDecimal, TimeUnit> unit,
			Function<Time, Time> translationToCanonical,
			Function<Time, Time> translationFromCanonical) {

		super(amount, unit, translationToCanonical, translationFromCanonical);
	}
}
