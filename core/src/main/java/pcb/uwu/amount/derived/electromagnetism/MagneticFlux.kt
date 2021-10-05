package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class MagneticFlux extends CompositeUnitAmount<MagneticFluxUnit> {

	// region constructors

	public MagneticFlux(Number value, MagneticFluxUnit unit) {
		super(value, unit);
	}

	public MagneticFlux(Number value, Magnitude magnitude, MagneticFluxUnit unit) {
		super(value, magnitude, unit);
	}

	public MagneticFlux(String value, MagneticFluxUnit unit) {
		super(value, unit);
	}

	public MagneticFlux(String value, Magnitude magnitude, MagneticFluxUnit unit) {
		super(value, magnitude, unit);
	}

	public MagneticFlux(BigDecimal value, MagneticFluxUnit unit) {
		super(value, unit);
	}

	public MagneticFlux(BigDecimal value, Magnitude magnitude, MagneticFluxUnit unit) {
		super(value, magnitude, unit);
	}

	public MagneticFlux(BigDecimalAmount amount, MagneticFluxUnit unit) {
		super(amount, unit);
	}

	public MagneticFlux(BigDecimalAmount amount, Magnitude magnitude, MagneticFluxUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public MagneticFlux plus(@NotNull UnitAmount<MagneticFluxUnit> other) {
		return new MagneticFlux(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public MagneticFlux minus(@NotNull UnitAmount<MagneticFluxUnit> other) {
		return new MagneticFlux(minusAmount(this, other), getUnit());
	}

	@Override
	public MagneticFlux multiply(BigDecimal other, MathContext mathContext) {
		return new MagneticFlux(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public MagneticFlux div(BigDecimal other, MathContext mathContext) {
		return new MagneticFlux(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public MagneticFlux into(MagneticFluxUnit unit) {
		return new MagneticFlux(getAmountIn(this, unit), unit);
	}

	// endregion
}
