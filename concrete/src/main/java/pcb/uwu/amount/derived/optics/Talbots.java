package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;
import static pcb.uwu.unit.derived.optics.TalbotUnit.TALBOT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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
	public Talbots plus(@NotNull UnitAmount<LuminousEnergyUnit> amount) {
		return new Talbots(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Talbots minus(@NotNull UnitAmount<LuminousEnergyUnit> amount) {
		return new Talbots(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Talbots times(@NotNull Number number) {
		return new Talbots(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Talbots div(@NotNull Number number) {
		return new Talbots(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	public Lumens div(Time time) {
		return new Lumens(getAmount().div(getAmountIn(time, SECOND)));
	}

	public Seconds div(LuminousFlux luminousFlux) {
		return new Seconds(getAmount().div(getAmountIn(luminousFlux, LUMEN)));
	}

	// endregion
}
