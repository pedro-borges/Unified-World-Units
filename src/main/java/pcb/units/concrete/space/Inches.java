package pcb.units.concrete.space;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Inches<A extends Amount<A>>
		extends AbstractUnitAmount<A, SpaceUnit>
		implements Space<A> {

	// region constructors

	public Inches(A amount) {
		super(amount, new InchUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Inches<A> plus(MathContext mathContext, UnitAmount<A, SpaceUnit> other) {
		Inches<A> inches = new Inches<>(other.getAmountIn(getUnit()));
		return new Inches<>(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches<A> minus(MathContext mathContext, UnitAmount<A, SpaceUnit> other) {
		Inches<A> inches = new Inches<>(other.getAmountIn(getUnit()));
		return new Inches<>(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches<A> multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Inches<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Inches<A> dividedBy(MathContext mathContext, BigDecimal other) {
		return new Inches<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
