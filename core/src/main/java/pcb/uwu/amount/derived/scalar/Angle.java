package pcb.uwu.amount.derived.scalar;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.scalar.AngleUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Angle extends CompositeUnitAmount<AngleUnit> {

	// region constructors

	public Angle(Number value, AngleUnit unit) {
		super(value, unit);
	}

	public Angle(Number value, Magnitude magnitude, AngleUnit unit) {
		super(value, magnitude, unit);
	}

	public Angle(String value, AngleUnit unit) {
		super(value, unit);
	}

	public Angle(String value, Magnitude magnitude, AngleUnit unit) {
		super(value, magnitude, unit);
	}

	public Angle(BigDecimal value, AngleUnit unit) {
		super(value, unit);
	}

	public Angle(BigDecimal value, Magnitude magnitude, AngleUnit unit) {
		super(value, magnitude, unit);
	}

	public Angle(BigDecimalAmount amount, AngleUnit unit) {
		super(amount, unit);
	}

	public Angle(BigDecimalAmount amount, Magnitude magnitude, AngleUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Angle plus(UnitAmount<AngleUnit> other, MathContext mathContext) {
		return new Angle(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Angle minus(UnitAmount<AngleUnit> other, MathContext mathContext) {
		return new Angle(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Angle multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Angle(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Angle dividedBy(BigDecimal other, MathContext mathContext) {
		return new Angle(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Angle in(AngleUnit unit) {
		return new Angle(getAmountIn(unit), unit);
	}

	// endregion

	// region composition



	// endregion
}
