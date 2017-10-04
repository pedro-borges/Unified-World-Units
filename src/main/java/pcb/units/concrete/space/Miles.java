package pcb.units.concrete.space;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Miles<A extends Amount<A>>
		extends AbstractUnitAmount<A, SpaceUnit>
		implements Space<A> {

	// region constructors

	public Miles(A amount) {
		super(amount, MileUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Miles<A> plus(MathContext mathContext, UnitAmount<A, SpaceUnit> other) {
		Miles<A> inches = new Miles<>(other.getAmountIn(getUnit()));
		return new Miles<>(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Miles<A> minus(MathContext mathContext, UnitAmount<A, SpaceUnit> other) {
		Miles<A> inches = new Miles<>(other.getAmountIn(getUnit()));
		return new Miles<>(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Miles<A> multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Miles<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Miles<A> dividedBy(MathContext mathContext, BigDecimal other) {
		return new Miles<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
