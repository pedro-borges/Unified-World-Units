package pcb.units.composite.finance;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.units.amount.BigDecimalAmount.IDENTITY;

public class InterestRate
		extends AbstractUnitAmount<BigDecimalAmount, InterestRateUnit>
		implements UnitAmount<BigDecimalAmount, InterestRateUnit> {

	// region factories

	public static InterestRate create(MathContext mathContext, Time time) {
		BigDecimalAmount amount = IDENTITY.dividedBy(time.getAmount().getValue(), mathContext);
		InterestRateUnit unit = new InterestRateUnit(time.getUnit());

		return new InterestRate(amount, unit);
	}

	// endregion

	// region constructors

	private InterestRate(BigDecimalAmount amount, InterestRateUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public InterestRate plus(MathContext mathContext, UnitAmount<BigDecimalAmount, InterestRateUnit> other) {
		return new InterestRate(getAmount().plus(other.getAmountIn(getUnit()), mathContext), getUnit());
	}

	@Override
	public InterestRate minus(MathContext mathContext, UnitAmount<BigDecimalAmount, InterestRateUnit> other) {
		return new InterestRate(getAmount().minus(other.getAmountIn(getUnit()), mathContext), getUnit());
	}

	@Override
	public InterestRate multipliedBy(MathContext mathContext, BigDecimal other) {
		return new InterestRate(getAmount().multipliedBy(other, mathContext), getUnit());
	}

	@Override
	public InterestRate dividedBy(MathContext mathContext, BigDecimal other) {
		return new InterestRate(getAmount().dividedBy(other, mathContext), getUnit());
	}

	// endregion
}
