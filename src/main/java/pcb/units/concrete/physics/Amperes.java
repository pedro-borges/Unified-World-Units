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
	public Amperes plus(UnitAmount<BigDecimalAmount, ElectricCurrentUnit> other, MathContext mathContext) {
		return new Amperes(plusAmount(other, mathContext));
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> minus(UnitAmount<BigDecimalAmount, ElectricCurrentUnit> other, MathContext mathContext) {
		return new Amperes(minusAmount(other, mathContext));
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Amperes(multipliedByAmount(other, mathContext));
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Amperes(dividedByAmount(other, mathContext));
	}

	// endregion
}
