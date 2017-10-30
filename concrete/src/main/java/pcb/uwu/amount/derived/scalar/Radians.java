package pcb.uwu.amount.derived.scalar;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.derived.scalar.AngleUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.scalar.RadianUnit.RADIAN;

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
		return new Radians(plusAmount(other, mathContext));
	}

	@Override
	public Radians minus(UnitAmount<AngleUnit> other, MathContext mathContext) {
		return new Radians(minusAmount(other, mathContext));
	}

	@Override
	public Radians multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Radians(multipliedByScalar(other, mathContext));
	}

	@Override
	public Radians dividedBy(BigDecimal other, MathContext mathContext) {
		return new Radians(dividedByScalar(other, mathContext));
	}

	// endregion
}
