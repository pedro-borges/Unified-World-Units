package pcb.uwu.amount.composite.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.fundamental.FrequencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Frequency extends CompositeUnitAmount<FrequencyUnit> {

	// region constructors

	public Frequency(Number value, FrequencyUnit unit) {
		super(value, unit);
	}

	public Frequency(Number value, Magnitude magnitude, FrequencyUnit unit) {
		super(value, magnitude, unit);
	}

	public Frequency(String value, FrequencyUnit unit) {
		super(value, unit);
	}

	public Frequency(String value, Magnitude magnitude, FrequencyUnit unit) {
		super(value, magnitude, unit);
	}

	public Frequency(BigDecimal value, FrequencyUnit unit) {
		super(value, unit);
	}

	public Frequency(BigDecimal value, Magnitude magnitude, FrequencyUnit unit) {
		super(value, magnitude, unit);
	}

	public Frequency(BigDecimalAmount amount, FrequencyUnit unit) {
		super(amount, unit);
	}

	public Frequency(BigDecimalAmount amount, Magnitude magnitude, FrequencyUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Frequency plus(UnitAmount<FrequencyUnit> other, MathContext mathContext) {
		return new Frequency(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Frequency minus(UnitAmount<FrequencyUnit> other, MathContext mathContext) {
		return new Frequency(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Frequency multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Frequency(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Frequency dividedBy(BigDecimal other, MathContext mathContext) {
		return new Frequency(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Frequency convertTo(FrequencyUnit unit) {
		return new Frequency(getAmountIn(unit), unit);
	}

	// endregion
}
