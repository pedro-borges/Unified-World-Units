package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousFluxUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class LuminousFlux extends CompositeUnitAmount<LuminousFluxUnit> {

	// region constructors

	public LuminousFlux(Number value, LuminousFluxUnit unit) {
		super(value, unit);
	}

	public LuminousFlux(Number value, Magnitude magnitude, LuminousFluxUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousFlux(String value, LuminousFluxUnit unit) {
		super(value, unit);
	}

	public LuminousFlux(String value, Magnitude magnitude, LuminousFluxUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousFlux(BigDecimal value, LuminousFluxUnit unit) {
		super(value, unit);
	}

	public LuminousFlux(BigDecimal value, Magnitude magnitude, LuminousFluxUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousFlux(BigDecimalAmount amount, LuminousFluxUnit unit) {
		super(amount, unit);
	}

	public LuminousFlux(BigDecimalAmount amount, Magnitude magnitude, LuminousFluxUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public LuminousFlux plus(@NotNull UnitAmount<LuminousFluxUnit> other) {
		return new LuminousFlux(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public LuminousFlux minus(@NotNull UnitAmount<LuminousFluxUnit> other) {
		return new LuminousFlux(minusAmount(this, other), getUnit());
	}

	@Override
	public LuminousFlux multiply(BigDecimal other, MathContext mathContext) {
		return new LuminousFlux(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public LuminousFlux div(BigDecimal other, MathContext mathContext) {
		return new LuminousFlux(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public LuminousFlux into(LuminousFluxUnit unit) {
		return new LuminousFlux(getAmountIn(this, unit), unit);
	}

	// endregion
}
