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

	// region constructors

	public Amperes(Number value) {
		this(value.toString());
	}

	public Amperes(String value) {
		this(new BigDecimal(value));
	}

	public Amperes(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Amperes(BigDecimalAmount amount) {
		super(amount, AmpereUnit.instance);
	}

	// endregion

	// region implement UnitAmount

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

	// endregion
}
