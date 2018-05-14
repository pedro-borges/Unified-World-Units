package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.FootUnit.FOOT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new Feet(plusAmount(this, other, mathContext));
	}

	@Override
	public Feet minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Feet(minusAmount(this, other, mathContext));
	}

	@Override
	public Feet multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Feet(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Feet dividedBy(BigDecimal other, MathContext mathContext) {
		return new Feet(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
