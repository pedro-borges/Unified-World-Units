package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.NauticalMileUnit.NAUTICALMILE;

public class NauticalMiles extends Length {

	// region constructors

	public NauticalMiles(Number value) {
		super(value, NAUTICALMILE);
	}

	public NauticalMiles(Number value, Magnitude magnitude) {
		super(value, magnitude, NAUTICALMILE);
	}

	public NauticalMiles(String value) {
		super(value, NAUTICALMILE);
	}

	public NauticalMiles(String value, Magnitude magnitude) {
		super(value, magnitude, NAUTICALMILE);
	}

	public NauticalMiles(BigDecimal value) {
		super(value, NAUTICALMILE);
	}

	public NauticalMiles(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NAUTICALMILE);
	}

	public NauticalMiles(BigDecimalAmount amount) {
		super(amount, NAUTICALMILE);
	}

	public NauticalMiles(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NAUTICALMILE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public NauticalMiles plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new NauticalMiles(plusAmount(other, mathContext));
	}

	@Override
	public NauticalMiles minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new NauticalMiles(minusAmount(other, mathContext));
	}

	@Override
	public NauticalMiles multipliedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles(multipliedByScalar(other, mathContext));
	}

	@Override
	public NauticalMiles dividedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
