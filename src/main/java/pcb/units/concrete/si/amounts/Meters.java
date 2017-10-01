package pcb.units.concrete.si.amounts;

import pcb.units.amount.Amount;
import pcb.units.amount.AmountFactory;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.si.MeterUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.MathContext;

public class Meters<N extends Number>
		extends AbstractUnitAmount<N, SpaceUnit<N>>
		implements Space<N> {

	// region constructors

	public Meters(N amount) {
		this(AmountFactory.amountOf(amount));
	}

	public Meters(Amount<N> amount) {
		super(amount, new MeterUnit<>());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Meters<N> plus(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Meters<N> meters = new Meters<>(other.getAmountIn(getUnit()));
		return new Meters<>(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters<N> minus(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Meters<N> meters = new Meters<>(other.getAmountIn(getUnit()));
		return new Meters<>(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters<N> multipliedBy(Amount<N> other, MathContext mathContext) {
		return new Meters<>(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Meters<N> dividedBy(Amount<N> other, MathContext mathContext) {
		return new Meters<>(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount<N> dividedBy(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Meters<N> meters = new Meters<>(other.getAmountIn(getUnit()));
		return getAmount().dividedBy(meters.getAmount(), mathContext);
	}

	// endregion
}
