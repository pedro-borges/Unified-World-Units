package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.electromagnetism.Coulombs;
import pcb.uwu.amount.derived.optics.LuminousFlux;
import pcb.uwu.amount.derived.optics.Talbots;
import pcb.uwu.amount.derived.thermodynamics.Joules;
import pcb.uwu.amount.derived.thermodynamics.Power;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;
import static pcb.uwu.unit.derived.termodynamics.WattUnit.WATT;

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

	// region composition

	public Coulombs multipliedBy(ElectricCurrent unitAmount, MathContext mathContext) {
		return new Coulombs(getAmount().multipliedBy(unitAmount.getAmountIn(AMPERE), mathContext));
	}

	public Joules multipliedBy(Power unitAmount, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(unitAmount.getAmountIn(WATT), mathContext));
	}

	public Talbots multipliedBy(LuminousFlux unitAmount, MathContext mathContext) {
		return new Talbots(getAmount().multipliedBy(unitAmount.getAmountIn(LUMEN), mathContext));
	}

	// endregion
}
