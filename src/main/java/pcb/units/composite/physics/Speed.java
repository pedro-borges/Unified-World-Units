package pcb.units.composite.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.time.Time;

import java.math.BigDecimal;
import java.math.MathContext;

public class Speed
		extends AbstractUnitAmount<BigDecimalAmount, SpeedUnit>
		implements UnitAmount<BigDecimalAmount, SpeedUnit> {

	// region factory

	public static Speed create(MathContext mathContext, Space<BigDecimalAmount> space, Time time) {
		BigDecimalAmount amount = space.getAmount().dividedBy(time.getAmount().getValue(), mathContext);
		SpeedUnit unit = new SpeedUnit(space.getUnit(), time.getUnit());

		return new Speed(amount, unit);
	}

	// endregion

	// region constructors

	public Speed(Number value, SpeedUnit unit) {
		this(value.toString(), unit);
	}

	public Speed(String value, SpeedUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Speed(BigDecimal value, SpeedUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Speed(BigDecimalAmount amount, SpeedUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Speed plus(MathContext mathContext, UnitAmount<BigDecimalAmount, SpeedUnit> other) {
		return new Speed(plusAmount(mathContext, other), getUnit());
	}

	@Override
	public Speed minus(MathContext mathContext, UnitAmount<BigDecimalAmount, SpeedUnit> other) {
		return new Speed(minusAmount(mathContext, other), getUnit());
	}

	@Override
	public Speed multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Speed(multipliedByAmount(mathContext, other), getUnit());
	}

	@Override
	public Speed dividedBy(MathContext mathContext, BigDecimal other) {
		return new Speed(dividedByAmount(mathContext, other), getUnit());
	}

	// endregion
}
