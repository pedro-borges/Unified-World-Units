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

	private Speed(BigDecimalAmount amount, SpeedUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Speed plus(MathContext mathContext, UnitAmount<BigDecimalAmount, SpeedUnit> other) {
		return new Speed(getAmount().plus(other.getAmountIn(getUnit()), mathContext), getUnit());
	}

	@Override
	public Speed minus(MathContext mathContext, UnitAmount<BigDecimalAmount, SpeedUnit> other) {
		return new Speed(getAmount().minus(other.getAmountIn(getUnit()), mathContext), getUnit());
	}

	@Override
	public Speed multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Speed(getAmount().multipliedBy(other, mathContext), getUnit());
	}

	@Override
	public Speed dividedBy(MathContext mathContext, BigDecimal other) {
		return new Speed(getAmount().dividedBy(other, mathContext), getUnit());
	}

	// endregion
}
