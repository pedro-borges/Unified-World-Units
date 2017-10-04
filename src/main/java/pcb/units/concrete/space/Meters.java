package pcb.units.concrete.space;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Meters<A extends Amount<A>>
		extends AbstractUnitAmount<A, SpaceUnit>
		implements Space<A> {

	// region constructors

	public Meters(A amount) {
		super(amount, MeterUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Meters<A> plus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Meters<A> meters = new Meters<>(other.getAmountIn(getUnit()));
		return new Meters<>(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters<A> minus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Meters<A> meters = new Meters<>(other.getAmountIn(getUnit()));
		return new Meters<>(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Meters<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Meters<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Meters<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
