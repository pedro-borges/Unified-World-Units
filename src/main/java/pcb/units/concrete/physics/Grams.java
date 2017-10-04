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
	public Grams plus(MathContext mathContext, UnitAmount<BigDecimalAmount, MassUnit> other) {
		return new Grams(plusAmount(mathContext, other));
	}

	@Override
	public Grams minus(MathContext mathContext, UnitAmount<BigDecimalAmount, MassUnit> other) {
		return new Grams(minusAmount(mathContext, other));
	}

	@Override
	public Grams multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Grams(multipliedByAmount(mathContext, other));
	}

	@Override
	public Grams dividedBy(MathContext mathContext, BigDecimal other) {
		return new Grams(dividedByAmount(mathContext, other));
	}

	// endregion
}
