package pcb.uwu.amount.derived.scalar;

import org.jetbrains.annotations.NotNull;
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

	@NotNull
	@Override
	public SolidAngle plus(@NotNull UnitAmount<SolidAngleUnit> other) {
		return new SolidAngle(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public SolidAngle minus(@NotNull UnitAmount<SolidAngleUnit> other) {
		return new SolidAngle(minusAmount(this, other), getUnit());
	}

	@Override
	public SolidAngle multiply(BigDecimal other, MathContext mathContext) {
		return new SolidAngle(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public SolidAngle div(BigDecimal other, MathContext mathContext) {
		return new SolidAngle(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public SolidAngle into(SolidAngleUnit unit) {
		return new SolidAngle(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	
	
	// endregion
}
