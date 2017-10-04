package pcb.units.concrete.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.physics.Mass;
import pcb.units.dimensions.physics.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Ounces
		extends AbstractUnitAmount<BigDecimalAmount, MassUnit>
		implements Mass {

	// region constructors

	public Ounces(Number value) {
		this(value.toString());
	}

	public Ounces(String value) {
		this(new BigDecimal(value));
	}

	public Ounces(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Ounces(BigDecimalAmount amount) {
		super(amount, OunceUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Ounces plus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Ounces(plusAmount(other, mathContext));
	}

	@Override
	public Ounces minus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Ounces(minusAmount(other, mathContext));
	}

	@Override
	public Ounces multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Ounces(multipliedByAmount(other, mathContext));
	}

	@Override
	public Ounces dividedBy(BigDecimal other, MathContext mathContext) {
		return new Ounces(dividedByAmount(other, mathContext));
	}

	// endregion
}
