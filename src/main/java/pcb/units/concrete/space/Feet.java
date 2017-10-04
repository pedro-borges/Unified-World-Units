package pcb.units.concrete.space;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Length;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Feet
		extends AbstractUnitAmount<BigDecimalAmount, SpaceUnit>
		implements Length {

	// region constructors

	public Feet(Number value) {
		this(value.toString());
	}

	public Feet(String value) {
		this(new BigDecimal(value));
	}

	public Feet(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Feet(BigDecimalAmount amount) {
		super(amount, FootUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Feet plus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Feet inches = new Feet(other.getAmountIn(getUnit()));
		return new Feet(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Feet minus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Feet inches = new Feet(other.getAmountIn(getUnit()));
		return new Feet(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Feet multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Feet(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Feet dividedBy(BigDecimal other, MathContext mathContext) {
		return new Feet(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
