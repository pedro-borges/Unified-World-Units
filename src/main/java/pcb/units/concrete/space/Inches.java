package pcb.units.concrete.space;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Length;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Inches
		extends AbstractUnitAmount<BigDecimalAmount, SpaceUnit>
		implements Length {

	// region constructors

	public Inches(Number value) {
		this(value.toString());
	}

	public Inches(String value) {
		this(new BigDecimal(value));
	}

	public Inches(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Inches(BigDecimalAmount amount) {
		super(amount, InchUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Inches plus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Inches inches = new Inches(other.getAmountIn(getUnit()));
		return new Inches(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches minus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Inches inches = new Inches(other.getAmountIn(getUnit()));
		return new Inches(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Inches(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Inches dividedBy(BigDecimal other, MathContext mathContext) {
		return new Inches(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
