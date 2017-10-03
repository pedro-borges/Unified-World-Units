package pcb.units.dimensions.physics;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.fundamental.Space;
import pcb.units.dimensions.fundamental.Time;

import java.math.BigDecimal;
import java.math.MathContext;

public class Speed<A extends Amount<A>>
		extends AbstractUnitAmount<A, SpeedUnit>
		implements UnitAmount<A, SpeedUnit> {

	// region factory

	public static <A extends Amount<A>> Speed<A> create(MathContext mathContext, Space<A> space, Time<A> time) {
		A amount = space.getAmount().dividedBy(time.getAmount().getValue(), mathContext);
		SpeedUnit unit = new SpeedUnit(space.getUnit(), time.getUnit());

		return new Speed<>(amount, unit);
	}

	// endregion

	// region constructors

	private Speed(A amount, SpeedUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public UnitAmount<A, SpeedUnit> plus(UnitAmount<A, SpeedUnit> other, MathContext mathContext) {
		return null;
	}

	@Override
	public UnitAmount<A, SpeedUnit> minus(UnitAmount<A, SpeedUnit> other, MathContext mathContext) {
		return null;
	}

	@Override
	public UnitAmount<A, SpeedUnit> multipliedBy(BigDecimal other, MathContext mathContext) {
		return null;
	}

	@Override
	public UnitAmount<A, SpeedUnit> dividedBy(BigDecimal other, MathContext mathContext) {
		return null;
	}

	// endregion
}
