package pcb.units.concrete.space;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Length;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class NauticalMiles
		extends AbstractUnitAmount<BigDecimalAmount, SpaceUnit>
		implements Length {

	// region constructors

	public NauticalMiles(Number value) {
		this(value.toString());
	}

	public NauticalMiles(String value) {
		this(new BigDecimal(value));
	}

	public NauticalMiles(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public NauticalMiles(BigDecimalAmount amount) {
		super(amount, NauticalMileUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public NauticalMiles plus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		NauticalMiles inches = new NauticalMiles(other.getAmountIn(getUnit()));
		return new NauticalMiles(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public NauticalMiles minus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		NauticalMiles inches = new NauticalMiles(other.getAmountIn(getUnit()));
		return new NauticalMiles(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public NauticalMiles multipliedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public NauticalMiles dividedBy(BigDecimal other, MathContext mathContext) {
		return new NauticalMiles(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
