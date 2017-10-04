package pcb.units.concrete.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.physics.LuminousIntensity;
import pcb.units.dimensions.physics.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Candelas
		extends AbstractUnitAmount<BigDecimalAmount, LuminousIntensityUnit>
		implements LuminousIntensity {

	// region constructors

	public Candelas(Number value) {
		this(value.toString());
	}

	public Candelas(String value) {
		this(new BigDecimal(value));
	}

	public Candelas(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Candelas(BigDecimalAmount amount) {
		super(amount, CandelaUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Candelas plus(UnitAmount<BigDecimalAmount, LuminousIntensityUnit> other, MathContext mathContext) {
		return new Candelas(plusAmount(other, mathContext));
	}

	@Override
	public Candelas minus(UnitAmount<BigDecimalAmount, LuminousIntensityUnit> other, MathContext mathContext) {
		return new Candelas(minusAmount(other, mathContext));
	}

	@Override
	public Candelas multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(multipliedByAmount(other, mathContext));
	}

	@Override
	public Candelas dividedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(dividedByAmount(other, mathContext));
	}
}
