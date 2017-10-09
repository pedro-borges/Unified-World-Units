package pcb.uwu.amount.composite.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.fundamental.FrequencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.fundamental.HertzUnit.HERTZ;

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
		return new Hertz(plusAmount(other, mathContext));
	}

	@Override
	public Hertz minus(UnitAmount<FrequencyUnit> other, MathContext mathContext) {
		return new Hertz(minusAmount(other, mathContext));
	}

	@Override
	public Hertz multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Hertz(multipliedByScalar(other, mathContext));
	}

	@Override
	public Hertz dividedBy(BigDecimal other, MathContext mathContext) {
		return new Hertz(dividedByScalar(other, mathContext));
	}

	// endregion
}
