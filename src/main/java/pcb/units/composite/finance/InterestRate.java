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

	public InterestRate(Number value, InterestRateUnit unit) {
		this(value.toString(), unit);
	}

	public InterestRate(String value, InterestRateUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public InterestRate(BigDecimal value, InterestRateUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public InterestRate(BigDecimalAmount amount, InterestRateUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public InterestRate plus(UnitAmount<BigDecimalAmount, InterestRateUnit> other, MathContext mathContext) {
		return new InterestRate(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public InterestRate minus(UnitAmount<BigDecimalAmount, InterestRateUnit> other, MathContext mathContext) {
		return new InterestRate(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public InterestRate multipliedBy(BigDecimal other, MathContext mathContext) {
		return new InterestRate(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public InterestRate dividedBy(BigDecimal other, MathContext mathContext) {
		return new InterestRate(dividedByAmount(other, mathContext), getUnit());
	}

	// endregion
}
