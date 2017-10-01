package pcb.units.concrete.fundamental.imperial.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.fundamental.imperial.InchUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;

public class Inches
		extends AbstractUnitAmount<SpaceUnit>
		implements Space {

	// region constructors

	public Inches(BigDecimal value) {
		this(new Amount(value));
	}

	public Inches(Amount amount) {
		super(amount, new InchUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Inches plus(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Inches inches = new Inches(other.getAmountIn(getUnit()));
		return new Inches(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches minus(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Inches inches = new Inches(other.getAmountIn(getUnit()));
		return new Inches(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches multipliedBy(Amount other, MathContext mathContext) {
		return new Inches(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Inches dividedBy(Amount other, MathContext mathContext) {
		return new Inches(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount dividedBy(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Inches inches = new Inches(other.getAmountIn(getUnit()));
		return getAmount().dividedBy(inches.getAmount(), mathContext);
	}

	// endregion
}
