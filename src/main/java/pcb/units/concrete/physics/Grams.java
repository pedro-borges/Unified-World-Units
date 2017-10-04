package pcb.units.concrete.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.physics.Mass;
import pcb.units.dimensions.physics.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Grams
		extends AbstractUnitAmount<BigDecimalAmount, MassUnit>
		implements Mass {

	// region constructors

	public Grams(Number value) {
		this(value.toString());
	}

	public Grams(String value) {
		this(new BigDecimal(value));
	}

	public Grams(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Grams(BigDecimalAmount amount) {
		super(amount, GramUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Grams plus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Grams(plusAmount(other, mathContext));
	}

	@Override
	public Grams minus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Grams(minusAmount(other, mathContext));
	}

	@Override
	public Grams multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Grams(multipliedByAmount(other, mathContext));
	}

	@Override
	public Grams dividedBy(BigDecimal other, MathContext mathContext) {
		return new Grams(dividedByAmount(other, mathContext));
	}

	// endregion
}
