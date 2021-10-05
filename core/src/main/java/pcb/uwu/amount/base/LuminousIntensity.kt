package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class LuminousIntensity extends CompositeUnitAmount<LuminousIntensityUnit> {

	// region constructors

	public LuminousIntensity(Number value, LuminousIntensityUnit unit) {
		super(value, unit);
	}

	public LuminousIntensity(Number value, Magnitude magnitude, LuminousIntensityUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousIntensity(String value, LuminousIntensityUnit unit) {
		super(value, unit);
	}

	public LuminousIntensity(String value, Magnitude magnitude, LuminousIntensityUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousIntensity(BigDecimal value, LuminousIntensityUnit unit) {
		super(value, unit);
	}

	public LuminousIntensity(BigDecimal value, Magnitude magnitude, LuminousIntensityUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousIntensity(BigDecimalAmount amount, LuminousIntensityUnit unit) {
		super(amount, unit);
	}

	public LuminousIntensity(BigDecimalAmount amount, Magnitude magnitude, LuminousIntensityUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public LuminousIntensity plus(@NotNull UnitAmount<LuminousIntensityUnit> other) {
		return new LuminousIntensity(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public LuminousIntensity minus(@NotNull UnitAmount<LuminousIntensityUnit> other) {
		return new LuminousIntensity(minusAmount(this, other), getUnit());
	}

	@Override
	public LuminousIntensity multiply(BigDecimal other, MathContext mathContext) {
		return new LuminousIntensity(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity div(BigDecimal other, MathContext mathContext) {
		return new LuminousIntensity(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity into(LuminousIntensityUnit unit) {
		return new LuminousIntensity(getAmountIn(this, unit), unit);
	}

	// endregion
}
