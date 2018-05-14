package pcb.uwu.amount.derived.mechanics;

import pcb.uwu.amount.base.Mass;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

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
	public Acceleration in(AccelerationUnit unit) {
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

	public Speed multipliedBy(Time time, MathContext mathContext) {
		LengthUnit lengthUnit = getUnit().getUnitCounter().findUnit(LengthUnit.class);
		TimeUnit timeUnit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		return new Speed(super.multipliedBy(time, mathContext).getAmount(), new SpeedUnit(lengthUnit, timeUnit));
	}

	// endregion
}
