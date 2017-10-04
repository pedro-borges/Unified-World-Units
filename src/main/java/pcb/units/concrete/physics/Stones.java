package pcb.units.concrete.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.physics.Mass;
import pcb.units.dimensions.physics.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Stones
		extends AbstractUnitAmount<BigDecimalAmount, MassUnit>
		implements Mass {

	// region constructors

	public Stones(Number value) {
		this(value.toString());
	}

	public Stones(String value) {
		this(new BigDecimal(value));
	}

	public Stones(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Stones(BigDecimalAmount amount) {
		super(amount, StoneUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Stones plus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Stones(plusAmount(other, mathContext));
	}

	@Override
	public Stones minus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Stones(minusAmount(other, mathContext));
	}

	@Override
	public Stones multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Stones(multipliedByAmount(other, mathContext));
	}

	@Override
	public Stones dividedBy(BigDecimal other, MathContext mathContext) {
		return new Stones(dividedByAmount(other, mathContext));
	}

	// endregion
}
