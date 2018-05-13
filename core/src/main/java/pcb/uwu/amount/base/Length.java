package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.mechanics.Speed;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.area.AreaUnit;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Length extends CompositeUnitAmount<LengthUnit> {

	// region constructors

	public Length(Number value, LengthUnit unit) {
		super(value, unit);
	}

	public Length(Number value, Magnitude magnitude, LengthUnit unit) {
		super(value, magnitude, unit);
	}

	public Length(String value, LengthUnit unit) {
		super(value, unit);
	}

	public Length(String value, Magnitude magnitude, LengthUnit unit) {
		super(value, magnitude, unit);
	}

	public Length(BigDecimal value, LengthUnit unit) {
		super(value, unit);
	}

	public Length(BigDecimal value, Magnitude magnitude, LengthUnit unit) {
		super(value, magnitude, unit);
	}

	public Length(BigDecimalAmount amount, LengthUnit unit) {
		super(amount, unit);
	}

	public Length(BigDecimalAmount amount, Magnitude magnitude, LengthUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Length plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Length(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Length minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Length(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Length multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Length(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Length dividedBy(BigDecimal other, MathContext mathContext) {
		return new Length(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Length convertTo(LengthUnit unit) {
		return new Length(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public Speed dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.dividedBy(time.getAmount().getValue(), mathContext);
		SpeedUnit unit = new SpeedUnit(getUnit(), time.getUnit());

		return new Speed(amount, unit);
	}

	public Time dividedBy(Speed speed, MathContext mathContext) {
		TimeUnit timeUnit = speed.getUnit().getUnitCounter().findUnit(TimeUnit.class);

		return new Time(super.dividedBy(speed, mathContext).getAmount(), timeUnit);
	}

	public Area multipliedBy(Length length, MathContext mathContext) {
		return new Area(
				getAmount().multipliedBy(length.getAmount(), mathContext),
				new AreaUnit(getUnit(), length.getUnit()));
	}

	// endregion
}
