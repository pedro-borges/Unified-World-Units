package pcb.uwu.amount.composite.mechanics;

import pcb.uwu.amount.quantity.Length;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.AccelerationUnit;
import pcb.uwu.units.composite.mechanics.SpeedUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Speed extends CompositeUnitAmount<SpeedUnit> {

	// region constructors

	public Speed(Number value, SpeedUnit unit) {
		super(value, unit);
	}

	public Speed(Number value, Magnitude magnitude, SpeedUnit unit) {
		super(value, magnitude, unit);
	}

	public Speed(String value, SpeedUnit unit) {
		super(value, unit);
	}

	public Speed(String value, Magnitude magnitude, SpeedUnit unit) {
		super(value, magnitude, unit);
	}

	public Speed(BigDecimal value, SpeedUnit unit) {
		super(value, unit);
	}

	public Speed(BigDecimal value, Magnitude magnitude, SpeedUnit unit) {
		super(value, magnitude, unit);
	}

	public Speed(BigDecimalAmount amount, SpeedUnit unit) {
		super(amount, unit);
	}

	public Speed(BigDecimalAmount amount, Magnitude magnitude, SpeedUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Speed plus(UnitAmount<SpeedUnit> other, MathContext mathContext) {
		return new Speed(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed minus(UnitAmount<SpeedUnit> other, MathContext mathContext) {
		return new Speed(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Speed dividedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Speed convertTo(SpeedUnit unit) {
		return new Speed(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public Acceleration dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.dividedBy(time.getAmount().getValue(), mathContext);
		AccelerationUnit unit = new AccelerationUnit(getUnit(), time.getUnit());

		return new Acceleration(amount, unit);
	}

	public Length multipliedBy(Time time, MathContext mathContext) {
		LengthUnit lengthUnit = getUnit().getUnitCounter().findUnit(LengthUnit.class);
		TimeUnit timeUnit = getUnit().getUnitCounter().findUnit(TimeUnit.class);
		BigDecimalAmount amount = getAmount()
				.multipliedBy(time.getAmountIn(timeUnit), mathContext);

		return new Length(amount, lengthUnit);
	}

	// endregion
}
