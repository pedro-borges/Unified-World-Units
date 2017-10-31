package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.PoundUnit.POUND;

public class Pounds extends Mass {

	// region constructors

	public Pounds(Number value) {
		super(value, POUND);
	}

	public Pounds(Number value, Magnitude magnitude) {
		super(value, magnitude, POUND);
	}

	public Pounds(String value) {
		super(value, POUND);
	}

	public Pounds(String value, Magnitude magnitude) {
		super(value, magnitude, POUND);
	}

	public Pounds(BigDecimal value) {
		super(value, POUND);
	}

	public Pounds(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, POUND);
	}

	public Pounds(BigDecimalAmount amount) {
		super(amount, POUND);
	}

	public Pounds(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, POUND);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Pounds plus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Pounds(plusAmount(other, mathContext));
	}

	@Override
	public Pounds minus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Pounds(minusAmount(other, mathContext));
	}

	@Override
	public Pounds multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Pounds(multipliedByScalar(other, mathContext));
	}

	@Override
	public Pounds dividedBy(BigDecimal other, MathContext mathContext) {
		return new Pounds(dividedByScalar(other, mathContext));
	}

	// endregion
}
