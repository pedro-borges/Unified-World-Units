package pcb.units.concrete.time;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Weeks
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements Time {

	// region constructors

	public Weeks(Number value) {
		this(value.toString());
	}

	public Weeks(String value) {
		this(new BigDecimal(value));
	}

	public Weeks(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Weeks(BigDecimalAmount amount) {
		super(amount, WeekUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Weeks plus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Weeks meters = new Weeks(other.getAmountIn(getUnit()));
		return new Weeks(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Weeks minus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Weeks meters = new Weeks(other.getAmountIn(getUnit()));
		return new Weeks(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Weeks multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Weeks(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Weeks dividedBy(BigDecimal other, MathContext mathContext) {
		return new Weeks(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
