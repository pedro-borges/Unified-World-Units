package pcb.uwu.amount.derived.mechanics;

import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;
import pcb.uwu.unit.derived.mechanics.PaceUnit;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

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
	public Speed in(SpeedUnit unit) {
		return new Speed(getAmountIn(this, unit), unit);
	}

	@Override
	public Pace invert(MathContext mathContext) {
		return new Pace(getAmount().invert(mathContext), new PaceUnit(getUnit()));
	}

	// endregion

	// region composition

	public Acceleration dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.dividedBy(time.getAmount().getValue(), mathContext);
		AccelerationUnit unit = new AccelerationUnit(getUnit(), time.getUnit());

		return new Acceleration(amount, unit);
	}

	public Time dividedBy(Acceleration acceleration, MathContext mathContext) {
		TimeUnit timeUnit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		return new Time(super.dividedBy(acceleration, mathContext).getAmount(), timeUnit);
	}

	public Length multipliedBy(Time time, MathContext mathContext) {
		LengthUnit lengthUnit = getUnit().getUnitCounter().findUnit(LengthUnit.class);

		return new Length(super.multipliedBy(time, mathContext).getAmount(), lengthUnit);
	}

	// endregion

}
