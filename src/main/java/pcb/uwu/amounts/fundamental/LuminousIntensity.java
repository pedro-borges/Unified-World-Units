package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class LuminousIntensity extends AbstractUnitAmount<LuminousIntensityUnit> {

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
	public LuminousIntensity convertTo(LuminousIntensityUnit unit) {
		return new LuminousIntensity(getAmountIn(unit), unit);
	}

	// endregion
}
