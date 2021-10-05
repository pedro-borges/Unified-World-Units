package pcb.uwu.amount.derived.fundamental;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.fundamental.FrequencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Frequency plus(@NotNull UnitAmount<FrequencyUnit> other) {
		return new Frequency(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public Frequency minus(@NotNull UnitAmount<FrequencyUnit> other) {
		return new Frequency(minusAmount(this, other), getUnit());
	}

	@Override
	public Frequency times(BigDecimal other, MathContext mathContext) {
		return new Frequency(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Frequency div(BigDecimal other, MathContext mathContext) {
		return new Frequency(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Frequency into(FrequencyUnit unit) {
		return new Frequency(getAmountIn(this, unit), unit);
	}

	@Override
	public Time invert(MathContext mathContext) {
		return new Time(getAmount().invert(mathContext), getUnit().getUnitCounter().findUnit(TimeUnit.class));
	}

	// endregion
}
