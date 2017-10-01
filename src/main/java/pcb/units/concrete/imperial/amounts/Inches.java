package pcb.units.concrete.imperial.amounts;

import pcb.units.amount.Amount;
import pcb.units.amount.AmountFactory;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.imperial.InchUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.MathContext;

public class Inches<N extends Number>
		extends AbstractUnitAmount<N, SpaceUnit<N>>
		implements Space<N> {

	// region constructors

	public Inches(N amount) {
		this(AmountFactory.amountOf(amount));
	}

	public Inches(Amount<N> amount) {
		super(amount, new InchUnit<>());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Inches<N> plus(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Inches<N> inches = new Inches<>(other.getAmountIn(getUnit()));
		return new Inches<>(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches<N> minus(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Inches<N> inches = new Inches<>(other.getAmountIn(getUnit()));
		return new Inches<>(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches<N> multipliedBy(Amount<N> other, MathContext mathContext) {
		return new Inches<>(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Inches<N> dividedBy(Amount<N> other, MathContext mathContext) {
		return new Inches<>(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount<N> dividedBy(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Inches<N> inches = new Inches<>(other.getAmountIn(getUnit()));
		return getAmount().dividedBy(inches.getAmount(), mathContext);
	}

	// endregion
}
