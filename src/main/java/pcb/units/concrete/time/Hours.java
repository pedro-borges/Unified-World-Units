package pcb.units.concrete.time;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Hours
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements Time {

	// region constructors

	public Hours(Number value) {
		this(value.toString());
	}

	public Hours(String value) {
		this(new BigDecimal(value));
	}

	public Hours(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Hours(BigDecimalAmount amount) {
		super(amount, HourUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Hours plus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Hours meters = new Hours(other.getAmountIn(getUnit()));
		return new Hours(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Hours minus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Hours meters = new Hours(other.getAmountIn(getUnit()));
		return new Hours(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Hours multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Hours(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Hours dividedBy(BigDecimal other, MathContext mathContext) {
		return new Hours(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
