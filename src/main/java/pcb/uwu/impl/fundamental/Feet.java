package pcb.uwu.impl.fundamental;

import pcb.uwu.amounts.fundamental.Length;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.fundamental.LengthUnit.FOOT;

public class Feet extends Length {

	// region constructors

	public Feet(Number value) {
		super(value, FOOT);
	}

	public Feet(Number value, Magnitude magnitude) {
		super(value, magnitude, FOOT);
	}

	public Feet(String value) {
		super(value, FOOT);
	}

	public Feet(String value, Magnitude magnitude) {
		super(value, magnitude, FOOT);
	}

	public Feet(BigDecimal value) {
		super(value, FOOT);
	}

	public Feet(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, FOOT);
	}

	public Feet(BigDecimalAmount amount) {
		super(amount, FOOT);
	}

	public Feet(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, FOOT);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Feet plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Feet(plusAmount(other, mathContext));
	}

	@Override
	public Feet minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Feet(minusAmount(other, mathContext));
	}

	@Override
	public Feet multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Feet(multipliedByScalar(other, mathContext));
	}

	@Override
	public Feet dividedBy(BigDecimal other, MathContext mathContext) {
		return new Feet(dividedByScalar(other, mathContext));
	}

	// endregion
}
