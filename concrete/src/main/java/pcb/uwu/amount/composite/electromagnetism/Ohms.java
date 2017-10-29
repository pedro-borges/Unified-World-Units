package pcb.uwu.amount.composite.electromagnetism;

import pcb.uwu.amount.quantity.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.ElectricResistanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;

public class Ohms extends ElectricResistance {

	// region constructors

	public Ohms(Number value) {
		super(value, OHM);
	}

	public Ohms(Number value, Magnitude magnitude) {
		super(value, magnitude, OHM);
	}

	public Ohms(String value) {
		super(value, OHM);
	}

	public Ohms(String value, Magnitude magnitude) {
		super(value, magnitude, OHM);
	}

	public Ohms(BigDecimal value) {
		super(value, OHM);
	}

	public Ohms(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, OHM);
	}

	public Ohms(BigDecimalAmount amount) {
		super(amount, OHM);
	}

	public Ohms(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, OHM);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Ohms plus(UnitAmount<ElectricResistanceUnit> other, MathContext mathContext) {
		return new Ohms(plusAmount(other, mathContext));
	}

	@Override
	public Ohms minus(UnitAmount<ElectricResistanceUnit> other, MathContext mathContext) {
		return new Ohms(minusAmount(other, mathContext));
	}

	@Override
	public Ohms multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Ohms(multipliedByScalar(other, mathContext));
	}

	@Override
	public Ohms dividedBy(BigDecimal other, MathContext mathContext) {
		return new Ohms(dividedByScalar(other, mathContext));
	}

	@Override
	public Ohms convertTo(ElectricResistanceUnit unit) {
		return new Ohms(getAmountIn(unit));
	}

	// endregion

	// region composition

	public Volts multipliedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Volts(getAmount().multipliedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	// endregion
}
