package pcb.units.concrete.time;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Seconds
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements Time {

	// region constructors

	public Seconds(Number value) {
		this(value.toString());
	}

	public Seconds(String value) {
		this(new BigDecimal(value));
	}

	public Seconds(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Seconds(BigDecimalAmount amount) {
		super(amount, SecondUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Seconds plus(MathContext mathContext, UnitAmount<BigDecimalAmount, TimeUnit> other) {
		Seconds meters = new Seconds(other.getAmountIn(getUnit()));
		return new Seconds(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds minus(MathContext mathContext, UnitAmount<BigDecimalAmount, TimeUnit> other) {
		Seconds meters = new Seconds(other.getAmountIn(getUnit()));
		return new Seconds(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Seconds multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Seconds(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Seconds dividedBy(MathContext mathContext, BigDecimal other) {
		return new Seconds(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
