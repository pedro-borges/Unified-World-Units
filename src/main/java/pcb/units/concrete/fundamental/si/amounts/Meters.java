package pcb.units.concrete.fundamental.si.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.fundamental.si.MeterUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;

public class Meters
		extends AbstractUnitAmount<SpaceUnit>
		implements Space {

	// region constructors

	public Meters(BigDecimal value) {
		this(new Amount(value));
	}

	public Meters(Amount amount) {
		super(amount, new MeterUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Meters plus(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Meters meters = new Meters(other.getAmountIn(getUnit()));
		return new Meters(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters minus(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Meters meters = new Meters(other.getAmountIn(getUnit()));
		return new Meters(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters multipliedBy(Amount other, MathContext mathContext) {
		return new Meters(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Meters dividedBy(Amount other, MathContext mathContext) {
		return new Meters(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount dividedBy(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Meters meters = new Meters(other.getAmountIn(getUnit()));
		return getAmount().dividedBy(meters.getAmount(), mathContext);
	}

	// endregion
}
