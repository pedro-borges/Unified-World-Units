package pcb.units.concrete.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.physics.ElectricCurrent;
import pcb.units.dimensions.physics.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Amperes
		extends AbstractUnitAmount<BigDecimalAmount, ElectricCurrentUnit>
		implements ElectricCurrent {

	public Amperes(BigDecimalAmount amount) {
		super(amount, AmpereUnit.instance);
	}

	@Override
	public Amperes plus(MathContext mathContext, UnitAmount<BigDecimalAmount, ElectricCurrentUnit> other) {
		return new Amperes(plusAmount(mathContext, other));
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> minus(MathContext mathContext, UnitAmount<BigDecimalAmount, ElectricCurrentUnit> other) {
		return new Amperes(minusAmount(mathContext, other));
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Amperes(multipliedByAmount(mathContext, other));
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> dividedBy(MathContext mathContext, BigDecimal other) {
		return new Amperes(dividedByAmount(mathContext, other));
	}
}
