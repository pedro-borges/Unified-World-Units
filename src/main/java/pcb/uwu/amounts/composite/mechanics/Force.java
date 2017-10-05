package pcb.uwu.amounts.composite.mechanics;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.ForceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Force extends AbstractUnitAmount<ForceUnit> {

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
		return new Force(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Force minus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Force(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Force multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Force(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Force dividedBy(BigDecimal other, MathContext mathContext) {
		return new Force(dividedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Force convertTo(ForceUnit unit) {
		return new Force(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	// endregion
}
