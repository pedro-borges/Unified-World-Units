package pcb.uwu.amount.derived.optics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousFluxUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

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

	@Override
	public LuminousFlux plus(UnitAmount<LuminousFluxUnit> other, MathContext mathContext) {
		return new LuminousFlux(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousFlux minus(UnitAmount<LuminousFluxUnit> other, MathContext mathContext) {
		return new LuminousFlux(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousFlux multipliedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousFlux(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public LuminousFlux dividedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousFlux(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public LuminousFlux in(LuminousFluxUnit unit) {
		return new LuminousFlux(getAmountIn(this, unit), unit);
	}

	// endregion
}
