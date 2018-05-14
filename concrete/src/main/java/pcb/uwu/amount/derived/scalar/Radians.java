package pcb.uwu.amount.derived.scalar;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.scalar.AngleUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.scalar.RadianUnit.RADIAN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Radians extends Angle {

	// region constructors

	public Radians(Number value) {
		super(value, RADIAN);
	}

	public Radians(Number value, Magnitude magnitude) {
		super(value, magnitude, RADIAN);
	}

	public Radians(String value) {
		super(value, RADIAN);
	}

	public Radians(String value, Magnitude magnitude) {
		super(value, magnitude, RADIAN);
	}

	public Radians(BigDecimal value) {
		super(value, RADIAN);
	}

	public Radians(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, RADIAN);
	}

	public Radians(BigDecimalAmount amount) {
		super(amount, RADIAN);
	}

	public Radians(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, RADIAN);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Radians plus(UnitAmount<AngleUnit> other, MathContext mathContext) {
		return new Radians(plusAmount(this, other, mathContext));
	}

	@Override
	public Radians minus(UnitAmount<AngleUnit> other, MathContext mathContext) {
		return new Radians(minusAmount(this, other, mathContext));
	}

	@Override
	public Radians multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Radians(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Radians dividedBy(BigDecimal other, MathContext mathContext) {
		return new Radians(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
