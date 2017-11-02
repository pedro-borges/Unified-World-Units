package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.InchUnit.INCH;

public class Inches extends Length {

	// region constructors

	public Inches(Number value) {
		super(value, INCH);
	}

	public Inches(Number value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(String value) {
		super(value, INCH);
	}

	public Inches(String value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(BigDecimal value) {
		super(value, INCH);
	}

	public Inches(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(BigDecimalAmount amount) {
		super(amount, INCH);
	}

	public Inches(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, INCH);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Inches plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Inches(plusAmount(other, mathContext));
	}

	@Override
	public Inches minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Inches(minusAmount(other, mathContext));
	}

	@Override
	public Inches multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Inches(multipliedByScalar(other, mathContext));
	}

	@Override
	public Inches dividedBy(BigDecimal other, MathContext mathContext) {
		return new Inches(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
