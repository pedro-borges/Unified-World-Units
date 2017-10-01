package pcb.units.concrete.si.amounts;

import pcb.units.amount.Amount;
import pcb.units.amount.AmountFactory;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.si.MeterUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.MathContext;

public class Seconds<N extends Number>
		extends AbstractUnitAmount<N, SpaceUnit<N>>
		implements Space<N> {

	// region constructors

	public Seconds(N amount) {
		this(AmountFactory.amountOf(amount));
	}

	public Seconds(Amount<N> amount) {
		super(amount, new MeterUnit<>());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Seconds<N> plus(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Seconds<N> meters = new Seconds<>(other.getAmountIn(getUnit()));
		return new Seconds<>(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds<N> minus(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Seconds<N> meters = new Seconds<>(other.getAmountIn(getUnit()));
		return new Seconds<>(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds<N> multipliedBy(Amount<N> other, MathContext mathContext) {
		return new Seconds<>(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Seconds<N> dividedBy(Amount<N> other, MathContext mathContext) {
		return new Seconds<>(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount<N> dividedBy(UnitAmount<N, SpaceUnit<N>> other, MathContext mathContext) {
		Seconds<N> meters = new Seconds<>(other.getAmountIn(getUnit()));
		return getAmount().dividedBy(meters.getAmount(), mathContext);
	}

	// endregion
}
