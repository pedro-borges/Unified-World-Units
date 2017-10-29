package pcb.uwu.amount.composite.termodynamics;

import pcb.uwu.amount.composite.electromagnetism.ElectricPotential;
import pcb.uwu.amount.composite.electromagnetism.Volts;
import pcb.uwu.amount.quantity.Amperes;
import pcb.uwu.amount.quantity.ElectricCurrent;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.termodynamics.PowerUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.composite.termodynamics.WattUnit.WATT;
import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class Watts extends Power {

	// region constructors

	public Watts(Number value) {
		super(value, WATT);
	}

	public Watts(Number value, Magnitude magnitude) {
		super(value, magnitude, WATT);
	}

	public Watts(String value) {
		super(value, WATT);
	}

	public Watts(String value, Magnitude magnitude) {
		super(value, magnitude, WATT);
	}

	public Watts(BigDecimal value) {
		super(value, WATT);
	}

	public Watts(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, WATT);
	}

	public Watts(BigDecimalAmount amount) {
		super(amount, WATT);
	}

	public Watts(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, WATT);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Watts plus(UnitAmount<PowerUnit> other, MathContext mathContext) {
		return new Watts(plusAmount(other, mathContext));
	}

	@Override
	public Watts minus(UnitAmount<PowerUnit> other, MathContext mathContext) {
		return new Watts(minusAmount(other, mathContext));
	}

	@Override
	public Watts multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Watts(multipliedByScalar(other, mathContext));
	}

	@Override
	public Watts dividedBy(BigDecimal other, MathContext mathContext) {
		return new Watts(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Joules multipliedBy(Time time, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(time.getAmountIn(SECOND), mathContext));
	}

	public Volts dividedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Volts(getAmount().dividedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	public Amperes dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Amperes(getAmount().dividedBy(electricPotential.getAmountIn(VOLT), mathContext));
	}

	// endregion
}
