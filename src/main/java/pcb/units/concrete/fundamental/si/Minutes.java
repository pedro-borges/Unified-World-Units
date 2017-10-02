package pcb.units.concrete.fundamental.si;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.fundamental.Time;
import pcb.units.dimensions.fundamental.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Minutes<A extends Amount<A>>
		extends AbstractUnitAmount<A, TimeUnit>
		implements Time<A> {

	// region constructors

	public Minutes(A amount) {
		super(amount, new MinuteUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Minutes<A> plus(UnitAmount<A, TimeUnit> other, MathContext mathContext) {
		Minutes<A> meters = new Minutes<>(other.getAmountIn(getUnit()));
		return new Minutes<>(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Minutes<A> minus(UnitAmount<A, TimeUnit> other, MathContext mathContext) {
		Minutes<A> meters = new Minutes<>(other.getAmountIn(getUnit()));
		return new Minutes<>(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Minutes<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Minutes<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Minutes<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Minutes<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
