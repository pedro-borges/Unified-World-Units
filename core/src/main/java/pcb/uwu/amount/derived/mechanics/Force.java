package pcb.uwu.amount.derived.mechanics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.mechanics.ForceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Force extends CompositeUnitAmount<ForceUnit> {

	// region constructors

	public Force(Number value, ForceUnit unit) {
		super(value, unit);
	}

	public Force(Number value, Magnitude magnitude, ForceUnit unit) {
		super(value, magnitude, unit);
	}

	public Force(String value, ForceUnit unit) {
		super(value, unit);
	}

	public Force(String value, Magnitude magnitude, ForceUnit unit) {
		super(value, magnitude, unit);
	}

	public Force(BigDecimal value, ForceUnit unit) {
		super(value, unit);
	}

	public Force(BigDecimal value, Magnitude magnitude, ForceUnit unit) {
		super(value, magnitude, unit);
	}

	public Force(BigDecimalAmount amount, ForceUnit unit) {
		super(amount, unit);
	}

	public Force(BigDecimalAmount amount, Magnitude magnitude, ForceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Force plus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Force(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Force minus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Force(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Force multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Force(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Force dividedBy(BigDecimal other, MathContext mathContext) {
		return new Force(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Force in(ForceUnit unit) {
		return new Force(getAmountIn(this, unit), unit);
	}

	// endregion
}
