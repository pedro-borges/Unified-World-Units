package pcb.uwu.amount.quantity;

import pcb.uwu.amount.composite.electromagnetism.Coulombs;
import pcb.uwu.amount.composite.termodynamics.Joules;
import pcb.uwu.amount.composite.termodynamics.Power;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.termodynamics.WattUnit.WATT;
import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class Seconds extends Time {

	// region constructors

	public Seconds(Number value) {
		super(value, SECOND);
	}

	public Seconds(Number value, Magnitude magnitude) {
		super(value, magnitude, SECOND);
	}

	public Seconds(String value) {
		super(value, SECOND);
	}

	public Seconds(String value, Magnitude magnitude) {
		super(value, magnitude, SECOND);
	}

	public Seconds(BigDecimal value) {
		super(value, SECOND);
	}

	public Seconds(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, SECOND);
	}

	public Seconds(BigDecimalAmount amount) {
		super(amount, SECOND);
	}

	public Seconds(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, SECOND);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Seconds plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Seconds(plusAmount(other, mathContext));
	}

	@Override
	public Seconds minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Seconds(minusAmount(other, mathContext));
	}

	@Override
	public Seconds multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds(multipliedByScalar(other, mathContext));
	}

	@Override
	public Seconds dividedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composite

	public Coulombs multipliedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Coulombs(getAmount().multipliedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	public Joules multipliedBy(Power power, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(power.getAmountIn(WATT), mathContext));
	}

	// endregion
}
