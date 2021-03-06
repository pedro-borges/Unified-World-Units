package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.NauticalMileUnit.NAUTICAL_MILE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class NauticalMiles extends Length {

	// region constructors

	public NauticalMiles(Number value) {
		super(value, NAUTICAL_MILE);
	}

	public NauticalMiles(Number value, Magnitude magnitude) {
		super(value, magnitude, NAUTICAL_MILE);
	}

	public NauticalMiles(String value) {
		super(value, NAUTICAL_MILE);
	}

	public NauticalMiles(String value, Magnitude magnitude) {
		super(value, magnitude, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimal value) {
		super(value, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimalAmount amount) {
		super(amount, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NAUTICAL_MILE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public NauticalMiles plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new NauticalMiles(plusAmount(this, other, mathContext));
	}

	@Override
	public NauticalMiles minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new NauticalMiles(minusAmount(this, other, mathContext));
	}

	@Override
	public NauticalMiles multipliedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public NauticalMiles dividedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
