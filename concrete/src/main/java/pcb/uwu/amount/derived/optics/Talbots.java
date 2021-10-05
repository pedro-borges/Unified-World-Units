package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;
import static pcb.uwu.unit.derived.optics.TalbotUnit.TALBOT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Talbots extends LuminousEnergy {

	// region constructors

	public Talbots(Number value) {
		super(value, TALBOT);
	}

	public Talbots(Number value, Magnitude magnitude) {
		super(value, magnitude, TALBOT);
	}

	public Talbots(String value) {
		super(value, TALBOT);
	}

	public Talbots(String value, Magnitude magnitude) {
		super(value, magnitude, TALBOT);
	}

	public Talbots(BigDecimal value) {
		super(value, TALBOT);
	}

	public Talbots(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, TALBOT);
	}

	public Talbots(BigDecimalAmount amount) {
		super(amount, TALBOT);
	}

	public Talbots(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, TALBOT);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Talbots plus(@NotNull UnitAmount<LuminousEnergyUnit> other) {
		return new Talbots(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Talbots minus(@NotNull UnitAmount<LuminousEnergyUnit> other) {
		return new Talbots(minusAmount(this, other));
	}

	@Override
	public Talbots times(BigDecimal other, MathContext mathContext) {
		return new Talbots(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Talbots div(BigDecimal other, MathContext mathContext) {
		return new Talbots(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Lumens dividedBy(Time time, MathContext mathContext) {
		return new Lumens(getAmount().div(getAmountIn(time, SECOND), mathContext));
	}

	public Seconds dividedBy(LuminousFlux luminousFlux, MathContext mathContext) {
		return new Seconds(getAmount().div(getAmountIn(luminousFlux, LUMEN), mathContext));
	}

	// endregion
}
