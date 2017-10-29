package pcb.uwu.amount.composite.mechanics;

import pcb.uwu.amount.quantity.Mass;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.AccelerationUnit;
import pcb.uwu.units.composite.mechanics.ForceUnit;
import pcb.uwu.units.composite.mechanics.SpeedUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

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
		return new Force(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Force minus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Force(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Force multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Force(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Force dividedBy(BigDecimal other, MathContext mathContext) {
		return new Force(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Force convertTo(ForceUnit unit) {
		return new Force(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public Mass dividedBy(Acceleration acceleration, MathContext mathContext) {
		MassUnit massUnit = getUnit().getUnitCounter().findUnit(MassUnit.class);

		return new Mass(super.dividedBy(acceleration, mathContext).getAmount(), massUnit);
	}

	public Acceleration dividedBy(Mass mass, MathContext mathContext) {
		LengthUnit lengthUnit = getUnit().getUnitCounter().findUnit(LengthUnit.class);
		TimeUnit timeUnit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		AccelerationUnit accelerationUnit = new AccelerationUnit(new SpeedUnit(lengthUnit, timeUnit), timeUnit);

		return new Acceleration(super.dividedBy(mass, mathContext).getAmount(), accelerationUnit);
	}

	// endregion
}
