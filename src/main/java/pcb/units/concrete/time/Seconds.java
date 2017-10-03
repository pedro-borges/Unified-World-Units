package pcb.units.concrete.time;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Seconds
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements Time {

	// region constructors

	public Seconds(BigDecimalAmount amount) {
		super(amount, new SecondUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Seconds plus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Seconds meters = new Seconds(other.getAmountIn(getUnit()));
		return new Seconds(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds minus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Seconds meters = new Seconds(other.getAmountIn(getUnit()));
		return new Seconds(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Seconds dividedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
