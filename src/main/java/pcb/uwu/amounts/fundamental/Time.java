package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Time extends AbstractUnitAmount<TimeUnit> {

	// region constructors

	public Time(Number value, TimeUnit unit) {
		super(value, unit);
	}

	public Time(Number value, Magnitude magnitude, TimeUnit unit) {
		super(value, magnitude, unit);
	}

	public Time(String value, TimeUnit unit) {
		super(value, unit);
	}

	public Time(String value, Magnitude magnitude, TimeUnit unit) {
		super(value, magnitude, unit);
	}

	public Time(BigDecimal value, TimeUnit unit) {
		super(value, unit);
	}

	public Time(BigDecimal value, Magnitude magnitude, TimeUnit unit) {
		super(value, magnitude, unit);
	}

	public Time(BigDecimalAmount amount, TimeUnit unit) {
		super(amount, unit);
	}

	public Time(BigDecimalAmount amount, Magnitude magnitude, TimeUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Time plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Time(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Time minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
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

	@Override
	public Time convertTo(TimeUnit unit) {
		return new Time(getAmountIn(unit), unit);
	}

	// endregion
}
