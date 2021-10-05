package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Luminance extends CompositeUnitAmount<LuminanceUnit> {

	// region constructors

	public Luminance(Number value, LuminanceUnit unit) {
		super(value, unit);
	}

	public Luminance(Number value, Magnitude magnitude, LuminanceUnit unit) {
		super(value, magnitude, unit);
	}

	public Luminance(String value, LuminanceUnit unit) {
		super(value, unit);
	}

	public Luminance(String value, Magnitude magnitude, LuminanceUnit unit) {
		super(value, magnitude, unit);
	}

	public Luminance(BigDecimal value, LuminanceUnit unit) {
		super(value, unit);
	}

	public Luminance(BigDecimal value, Magnitude magnitude, LuminanceUnit unit) {
		super(value, magnitude, unit);
	}

	public Luminance(BigDecimalAmount amount, LuminanceUnit unit) {
		super(amount, unit);
	}

	public Luminance(BigDecimalAmount amount, Magnitude magnitude, LuminanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Luminance plus(@NotNull UnitAmount<LuminanceUnit> other) {
		return new Luminance(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public Luminance minus(@NotNull UnitAmount<LuminanceUnit> other) {
		return new Luminance(minusAmount(this, other), getUnit());
	}

	@Override
	public Luminance multiply(BigDecimal other, MathContext mathContext) {
		return new Luminance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Luminance div(BigDecimal other, MathContext mathContext) {
		return new Luminance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Luminance into(LuminanceUnit unit) {
		return new Luminance(getAmountIn(this, unit), unit);
	}

	// endregion
}
