package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
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
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Seconds plus(@NotNull UnitAmount<TimeUnit> other) {
		return new Seconds(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Seconds minus(@NotNull UnitAmount<TimeUnit> other) {
		return new Seconds(minusAmount(this, other));
	}

	@Override
	public Seconds times(BigDecimal other, MathContext mathContext) {
		return new Seconds(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Seconds div(BigDecimal other, MathContext mathContext) {
		return new Seconds(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Coulombs multipliedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Coulombs(getAmount().times(getAmountIn(electricCurrent, AMPERE), mathContext));
	}

	public Joules multipliedBy(Power power, MathContext mathContext) {
		return new Joules(getAmount().times(getAmountIn(power, WATT), mathContext));
	}

	public Talbots multipliedBy(LuminousFlux luminousFlux, MathContext mathContext) {
		return new Talbots(getAmount().times(getAmountIn(luminousFlux, LUMEN), mathContext));
	}

	// endregion
}
