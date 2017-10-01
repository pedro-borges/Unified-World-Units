package pcb.units.concrete.fundamental.si.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.fundamental.si.MeterUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;

public class Seconds
		extends AbstractUnitAmount<SpaceUnit>
		implements Space {

	// region constructors

	public Seconds(BigDecimal value) {
		this(new Amount(value));
	}

	public Seconds(Amount amount) {
		super(amount, new MeterUnit());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Seconds plus(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Seconds meters = new Seconds(other.getAmountIn(getUnit()));
		return new Seconds(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds minus(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Seconds meters = new Seconds(other.getAmountIn(getUnit()));
		return new Seconds(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds multipliedBy(Amount other, MathContext mathContext) {
		return new Seconds(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Seconds dividedBy(Amount other, MathContext mathContext) {
		return new Seconds(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount dividedBy(UnitAmount<SpaceUnit> other, MathContext mathContext) {
		Seconds meters = new Seconds(other.getAmountIn(getUnit()));
		return getAmount().dividedBy(meters.getAmount(), mathContext);
	}

	// endregion
}
