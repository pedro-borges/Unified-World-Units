package pcb.units.concrete.time;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Days
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements Time {

	// region constructors

	public Days(Number value) {
		this(value.toString());
	}

	public Days(String value) {
		this(new BigDecimal(value));
	}

	public Days(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Days(BigDecimalAmount amount) {
		super(amount, DayUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Days plus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Days meters = new Days(other.getAmountIn(getUnit()));
		return new Days(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Days minus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Days meters = new Days(other.getAmountIn(getUnit()));
		return new Days(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Days multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Days(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Days dividedBy(BigDecimal other, MathContext mathContext) {
		return new Days(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
