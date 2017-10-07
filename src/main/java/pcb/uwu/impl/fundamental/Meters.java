package pcb.uwu.impl.fundamental;

import pcb.uwu.amounts.fundamental.Length;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.fundamental.LengthUnit.METER;

public class Meters extends Length {

	// region constructors

	public Meters(Number value) {
		super(value, METER);
	}

	public Meters(Number value, Magnitude magnitude) {
		super(value, magnitude, METER);
	}

	public Meters(String value) {
		super(value, METER);
	}

	public Meters(String value, Magnitude magnitude) {
		super(value, magnitude, METER);
	}

	public Meters(BigDecimal value) {
		super(value, METER);
	}

	public Meters(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, METER);
	}

	public Meters(BigDecimalAmount amount) {
		super(amount, METER);
	}

	public Meters(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, METER);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Meters plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Meters(plusAmount(other, mathContext));
	}

	@Override
	public Meters minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Meters(minusAmount(other, mathContext));
	}

	@Override
	public Meters multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Meters(multipliedByScalar(other, mathContext));
	}

	@Override
	public Meters dividedBy(BigDecimal other, MathContext mathContext) {
		return new Meters(dividedByScalar(other, mathContext));
	}

	// endregion
}
