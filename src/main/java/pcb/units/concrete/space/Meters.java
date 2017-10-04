package pcb.units.concrete.space;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Length;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Meters
		extends AbstractUnitAmount<BigDecimalAmount, SpaceUnit>
		implements Length {

	// region constructors

	public Meters(Number value) {
		this(value.toString());
	}

	public Meters(String value) {
		this(new BigDecimal(value));
	}

	public Meters(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Meters(BigDecimalAmount amount) {
		super(amount, MeterUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Meters plus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Meters meters = new Meters(other.getAmountIn(getUnit()));
		return new Meters(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters minus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Meters meters = new Meters(other.getAmountIn(getUnit()));
		return new Meters(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Meters(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Meters dividedBy(BigDecimal other, MathContext mathContext) {
		return new Meters(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
