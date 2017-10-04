package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class LuminousIntensity
		extends AbstractUnitAmount<BigDecimalAmount, LuminousIntensityUnit>
		implements UnitAmount<BigDecimalAmount, LuminousIntensityUnit> {

	// region constructors

	public LuminousIntensity(Number value, LuminousIntensityUnit unit) {
		this(value.toString(), unit);
	}

	public LuminousIntensity(String value, LuminousIntensityUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public LuminousIntensity(BigDecimal value, LuminousIntensityUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public LuminousIntensity(BigDecimalAmount amount, LuminousIntensityUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public LuminousIntensity plus(UnitAmount<BigDecimalAmount, LuminousIntensityUnit> other, MathContext mathContext) {
		return new LuminousIntensity(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity minus(UnitAmount<BigDecimalAmount, LuminousIntensityUnit> other, MathContext mathContext) {
		return new LuminousIntensity(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity multipliedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousIntensity(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousIntensity dividedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousIntensity(dividedByAmount(other, mathContext), getUnit());
	}
}
