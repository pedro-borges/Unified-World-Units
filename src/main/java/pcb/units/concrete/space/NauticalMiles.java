package pcb.units.concrete.space;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class NauticalMiles<A extends Amount<A>>
		extends AbstractUnitAmount<A, SpaceUnit>
		implements Space<A> {

	// region constructors

	public NauticalMiles(A amount) {
		super(amount, NauticalMileUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public NauticalMiles<A> plus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		NauticalMiles<A> inches = new NauticalMiles<>(other.getAmountIn(getUnit()));
		return new NauticalMiles<>(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public NauticalMiles<A> minus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		NauticalMiles<A> inches = new NauticalMiles<>(other.getAmountIn(getUnit()));
		return new NauticalMiles<>(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public NauticalMiles<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public NauticalMiles<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
