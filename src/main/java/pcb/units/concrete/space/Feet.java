package pcb.units.concrete.space;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Feet<A extends Amount<A>>
		extends AbstractUnitAmount<A, SpaceUnit>
		implements Space<A> {

	// region constructors

	public Feet(A amount) {
		super(amount, FootUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Feet<A> plus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Feet<A> inches = new Feet<>(other.getAmountIn(getUnit()));
		return new Feet<>(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Feet<A> minus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Feet<A> inches = new Feet<>(other.getAmountIn(getUnit()));
		return new Feet<>(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Feet<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Feet<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Feet<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Feet<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
