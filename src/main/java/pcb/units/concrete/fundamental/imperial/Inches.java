package pcb.units.concrete.fundamental.imperial;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.fundamental.Space;
import pcb.units.dimensions.fundamental.SpaceUnit;

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
	public Inches<A> plus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Inches<A> inches = new Inches<>(other.getAmountIn(getUnit()));
		return new Inches<>(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches<A> minus(UnitAmount<A, SpaceUnit> other, MathContext mathContext) {
		Inches<A> inches = new Inches<>(other.getAmountIn(getUnit()));
		return new Inches<>(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Inches<>(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Inches<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Inches<>(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
