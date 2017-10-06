package pcb.uwu.amounts.fundamental;

import pcb.uwu.amounts.composite.mechanics.Speed;
import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.SpeedUnit;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Length extends AbstractUnitAmount<LengthUnit> {

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

	// endregion
}
