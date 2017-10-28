package pcb.uwu.amount.composite.mechanics;

import pcb.uwu.amount.quantity.Mass;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.AccelerationUnit;
import pcb.uwu.units.composite.mechanics.ForceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Acceleration extends CompositeUnitAmount<AccelerationUnit> {

	// region constructors

	public Acceleration(Number value, AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(Number value, Magnitude magnitude, AccelerationUnit unit) {
		super(value, magnitude, unit);
	}

	public Acceleration(String value, AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(String value, Magnitude magnitude, AccelerationUnit unit) {
		super(value, magnitude, unit);
	}

	public Acceleration(BigDecimal value, AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(BigDecimal value, Magnitude magnitude, AccelerationUnit unit) {
		super(value, magnitude, unit);
	}

	public Acceleration(BigDecimalAmount amount, AccelerationUnit unit) {
		super(amount, unit);
	}

	public Acceleration(BigDecimalAmount amount, Magnitude magnitude, AccelerationUnit unit) {
		super(amount, magnitude, unit);
	}
	
	// endregion

	// region implement UnitAmount

	@Override
	public Acceleration plus(UnitAmount<AccelerationUnit> other, MathContext mathContext) {
		return new Acceleration(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Acceleration minus(UnitAmount<AccelerationUnit> other, MathContext mathContext) {
		return new Acceleration(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Acceleration multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Acceleration(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Acceleration dividedBy(BigDecimal other, MathContext mathContext) {
		return new Acceleration(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Acceleration convertTo(AccelerationUnit unit) {
		return new Acceleration(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public Force multipliedBy(Mass mass, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.multipliedBy(mass.getAmount().getValue(), mathContext);
		ForceUnit unit = new ForceUnit(mass.getUnit(), getUnit());

		return new Force(amount, unit);
	}

	// endregion
}
