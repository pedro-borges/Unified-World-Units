package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

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

	@Override
	public LuminousIntensity plus(UnitAmount<LuminousIntensityUnit> other, MathContext mathContext) {
		return new LuminousIntensity(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity minus(UnitAmount<LuminousIntensityUnit> other, MathContext mathContext) {
		return new LuminousIntensity(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity multipliedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousIntensity(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity dividedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousIntensity(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity in(LuminousIntensityUnit unit) {
		return new LuminousIntensity(getAmountIn(this, unit), unit);
	}

	// endregion
}
