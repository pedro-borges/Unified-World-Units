package pcb.units.concrete.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.physics.Mass;
import pcb.units.dimensions.physics.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Pounds
		extends AbstractUnitAmount<BigDecimalAmount, MassUnit>
		implements Mass {

	// region constructors

	public Pounds(Number value) {
		this(value.toString());
	}

	public Pounds(String value) {
		this(new BigDecimal(value));
	}

	public Pounds(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Pounds(BigDecimalAmount amount) {
		super(amount, PoundUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Pounds plus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Pounds(plusAmount(other, mathContext));
	}

	@Override
	public Pounds minus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Pounds(minusAmount(other, mathContext));
	}

	@Override
	public Pounds multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Pounds(multipliedByAmount(other, mathContext));
	}

	@Override
	public Pounds dividedBy(BigDecimal other, MathContext mathContext) {
		return new Pounds(dividedByAmount(other, mathContext));
	}

	// endregion
}
