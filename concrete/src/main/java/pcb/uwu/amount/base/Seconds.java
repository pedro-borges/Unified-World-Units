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
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;
import static pcb.uwu.unit.derived.termodynamics.WattUnit.WATT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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
	public Seconds plus(@NotNull UnitAmount<TimeUnit> amount) {
		return new Seconds(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Seconds minus(@NotNull UnitAmount<TimeUnit> amount) {
		return new Seconds(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Seconds times(@NotNull Number number) {
		return new Seconds(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Seconds div(@NotNull Number number) {
		return new Seconds(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	public Coulombs times(ElectricCurrent electricCurrent) {
		return new Coulombs(getAmount().times(getAmountIn(electricCurrent, AMPERE)));
	}

	public Joules times(Power power) {
		return new Joules(getAmount().times(getAmountIn(power, WATT)));
	}

	public Talbots times(LuminousFlux luminousFlux) {
		return new Talbots(getAmount().times(getAmountIn(luminousFlux, LUMEN)));
	}

	// endregion
}
