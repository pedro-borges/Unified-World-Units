package pcb.uwu.amount.composite.mechanics;

import pcb.uwu.amount.quantity.Mass;
import pcb.uwu.core.BigDecimalAmount;
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

import static pcb.uwu.unit.composite.mechanics.NewtonUnit.NEWTON;

public class Newtons extends Force {

	// region constructors

	public Newtons(Number value) {
		super(value, NEWTON);
	}

	public Newtons(Number value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(String value) {
		super(value, NEWTON);
	}

	public Newtons(String value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(BigDecimal value) {
		super(value, NEWTON);
	}

	public Newtons(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(BigDecimalAmount amount) {
		super(amount, NEWTON);
	}

	public Newtons(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NEWTON);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Newtons plus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Newtons(plusAmount(other, mathContext));
	}

	@Override
	public Newtons minus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Newtons(minusAmount(other, mathContext));
	}

	@Override
	public Newtons multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Newtons(multipliedByScalar(other, mathContext));
	}

	@Override
	public Newtons dividedBy(BigDecimal other, MathContext mathContext) {
		return new Newtons(dividedByScalar(other, mathContext));
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

		return new Acceleration(
				super.dividedBy(mass, mathContext).getAmount(),
				new AccelerationUnit(new SpeedUnit(lengthUnit, timeUnit), timeUnit));
	}

	// endregion
}
