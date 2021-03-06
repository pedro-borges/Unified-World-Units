package pcb.uwu.amount.derived.scalar;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.scalar.SolidAngleUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class SolidAngle extends CompositeUnitAmount<SolidAngleUnit> {

	// region constructors

	public SolidAngle(Number value, SolidAngleUnit unit) {
		super(value, unit);
	}

	public SolidAngle(Number value, Magnitude magnitude, SolidAngleUnit unit) {
		super(value, magnitude, unit);
	}

	public SolidAngle(String value, SolidAngleUnit unit) {
		super(value, unit);
	}

	public SolidAngle(String value, Magnitude magnitude, SolidAngleUnit unit) {
		super(value, magnitude, unit);
	}

	public SolidAngle(BigDecimal value, SolidAngleUnit unit) {
		super(value, unit);
	}

	public SolidAngle(BigDecimal value, Magnitude magnitude, SolidAngleUnit unit) {
		super(value, magnitude, unit);
	}

	public SolidAngle(BigDecimalAmount amount, SolidAngleUnit unit) {
		super(amount, unit);
	}

	public SolidAngle(BigDecimalAmount amount, Magnitude magnitude, SolidAngleUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public SolidAngle plus(UnitAmount<SolidAngleUnit> other, MathContext mathContext) {
		return new SolidAngle(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public SolidAngle minus(UnitAmount<SolidAngleUnit> other, MathContext mathContext) {
		return new SolidAngle(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public SolidAngle multipliedBy(BigDecimal other, MathContext mathContext) {
		return new SolidAngle(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public SolidAngle dividedBy(BigDecimal other, MathContext mathContext) {
		return new SolidAngle(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public SolidAngle in(SolidAngleUnit unit) {
		return new SolidAngle(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	
	
	// endregion
}
