package pcb.units.concrete.fundamental.si.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.fundamental.si.SecondUnit;
import pcb.units.dimensions.fundamental.TimeUnit;
import pcb.units.dimensions.fundamental.amounts.Time;

import java.math.BigDecimal;
import java.math.MathContext;

public class Seconds<A extends Amount<A>>
		extends AbstractUnitAmount<A, TimeUnit>
		implements Time<A> {

	// region constructors

	public Seconds(A amount) {
		super(amount, new SecondUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Seconds<A> plus(UnitAmount<A, TimeUnit> other, MathContext mathContext) {
		Seconds<A> meters = new Seconds<>(other.getAmountIn(getUnit()));
		return new Seconds<>(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds<A> minus(UnitAmount<A, TimeUnit> other, MathContext mathContext) {
		Seconds<A> meters = new Seconds<>(other.getAmountIn(getUnit()));
		return new Seconds<>(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Seconds<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds<>(getAmount().dividedBy(other, mathContext));
	}

	@Override
	public BigDecimal dividedBy(UnitAmount<A, TimeUnit> other, MathContext mathContext) {
		Seconds<A> meters = new Seconds<>(other.getAmountIn(getUnit()));
		return getAmount().dividedBy(meters.getAmount(), mathContext);
	}

	// endregion
}
