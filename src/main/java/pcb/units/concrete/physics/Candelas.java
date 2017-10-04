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

	public Candelas(BigDecimalAmount amount) {
		super(amount, CandelaUnit.instance);
	}

	@Override
	public Candelas plus(MathContext mathContext, UnitAmount<BigDecimalAmount, LuminousIntensityUnit> other) {
		return new Candelas(plusAmount(mathContext, other));
	}

	@Override
	public Candelas minus(MathContext mathContext, UnitAmount<BigDecimalAmount, LuminousIntensityUnit> other) {
		return new Candelas(minusAmount(mathContext, other));
	}

	@Override
	public Candelas multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Candelas(multipliedByAmount(mathContext, other));
	}

	@Override
	public Candelas dividedBy(MathContext mathContext, BigDecimal other) {
		return new Candelas(dividedByAmount(mathContext, other));
	}
}
