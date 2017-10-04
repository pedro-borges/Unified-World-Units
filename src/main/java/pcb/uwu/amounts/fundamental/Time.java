package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Time
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements UnitAmount<BigDecimalAmount, TimeUnit> {

	// region constructors

	public Time(Number value, TimeUnit unit) {
		this(value.toString(), unit);
	}

	public Time(String value, TimeUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Time(BigDecimal value, TimeUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Time(BigDecimalAmount amount, TimeUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Time plus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		return new Time(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Time minus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		return new Time(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Time multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Time(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Time dividedBy(BigDecimal other, MathContext mathContext) {
		return new Time(dividedByAmount(other, mathContext), getUnit());
	}

	// endregion
}
