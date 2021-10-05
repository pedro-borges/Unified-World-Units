package pcb.uwu.amount.derived.thermodynamics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential;
import pcb.uwu.amount.derived.electromagnetism.Volts;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.PowerUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.derived.termodynamics.WattUnit.WATT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Watts plus(@NotNull UnitAmount<PowerUnit> other) {
		return new Watts(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Watts minus(@NotNull UnitAmount<PowerUnit> other) {
		return new Watts(minusAmount(this, other));
	}

	@Override
	public Watts multiply(BigDecimal other, MathContext mathContext) {
		return new Watts(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Watts div(BigDecimal other, MathContext mathContext) {
		return new Watts(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Joules multipliedBy(Time time, MathContext mathContext) {
		return new Joules(getAmount().times(getAmountIn(time, SECOND), mathContext));
	}

	public Volts dividedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Volts(getAmount().div(getAmountIn(electricCurrent, AMPERE), mathContext));
	}

	public Amperes dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Amperes(getAmount().div(getAmountIn(electricPotential, VOLT), mathContext));
	}

	// endregion
}
