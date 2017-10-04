package pcb.units.concrete.space;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Yards<A extends Amount<A>>
		extends AbstractUnitAmount<A, SpaceUnit>
		implements Space<A> {

	// region constructors

	public Yards(A amount) {
		super(amount, YardUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Yards<A> plus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Yards<A> inches = new Yards<>(other.getAmountIn(getUnit()));
		return new Yards<>(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Yards<A> minus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Yards<A> inches = new Yards<>(other.getAmountIn(getUnit()));
		return new Yards<>(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Yards<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Yards<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Yards<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Yards<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
