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

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new Speed(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Speed minus(UnitAmount<SpeedUnit> other, MathContext mathContext) {
		return new Speed(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Speed multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Speed dividedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(dividedByScalar(this, other, mathContext), getUnit());
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
		BigDecimalAmount amount = getAmount().dividedBy(time.getAmount().getValue(), mathContext);
		AccelerationUnit unit = new AccelerationUnit(getUnit(), time.getUnit());

		return new Acceleration(amount, unit);
	}

	public Time dividedBy(Acceleration acceleration, MathContext mathContext) {
		BigDecimalAmount amount = super.dividedBy(acceleration, mathContext).getAmount();
		TimeUnit unit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		return new Time(amount, unit);
	}

	public Length multipliedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = super.multipliedBy(time, mathContext).getAmount();
		LengthUnit unit = getUnit().getUnitCounter().findUnit(LengthUnit.class);

		return new Length(amount, unit);
	}

	// endregion

}
