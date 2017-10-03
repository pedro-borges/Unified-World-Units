package pcb.units.concrete.time;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Minutes
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements Time {

	// region constructors

	public Minutes(BigDecimalAmount amount) {
		super(amount, new MinuteUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Minutes plus(MathContext mathContext, UnitAmount<BigDecimalAmount, TimeUnit> other) {
		Minutes meters = new Minutes(other.getAmountIn(getUnit()));
		return new Minutes(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Minutes minus(MathContext mathContext, UnitAmount<BigDecimalAmount, TimeUnit> other) {
		Minutes meters = new Minutes(other.getAmountIn(getUnit()));
		return new Minutes(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Minutes multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Minutes(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Minutes dividedBy(MathContext mathContext, BigDecimal other) {
		return new Minutes(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
