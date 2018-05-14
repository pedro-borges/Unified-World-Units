package pcb.uwu.amount.derived.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.FrequencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.fundamental.HertzUnit.HERTZ;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Hertz extends Frequency {
	
	// region constructors
	
	public Hertz(Number value) {
		super(value, HERTZ);
	}

	public Hertz(Number value, Magnitude magnitude) {
		super(value, magnitude, HERTZ);
	}

	public Hertz(String value) {
		super(value, HERTZ);
	}

	public Hertz(String value, Magnitude magnitude) {
		super(value, magnitude, HERTZ);
	}

	public Hertz(BigDecimal value) {
		super(value, HERTZ);
	}

	public Hertz(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, HERTZ);
	}

	public Hertz(BigDecimalAmount amount) {
		super(amount, HERTZ);
	}

	public Hertz(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, HERTZ);
	}
	
	// endregion

	// region implement UnitAmount

	@Override
	public Hertz plus(UnitAmount<FrequencyUnit> other, MathContext mathContext) {
		return new Hertz(plusAmount(this, other, mathContext));
	}

	@Override
	public Hertz minus(UnitAmount<FrequencyUnit> other, MathContext mathContext) {
		return new Hertz(minusAmount(this, other, mathContext));
	}

	@Override
	public Hertz multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Hertz(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Hertz dividedBy(BigDecimal other, MathContext mathContext) {
		return new Hertz(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
