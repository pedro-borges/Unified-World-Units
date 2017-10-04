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
	public InterestRate plus(MathContext mathContext, UnitAmount<BigDecimalAmount, InterestRateUnit> other) {
		return new InterestRate(plusAmount(mathContext, other), getUnit());
	}

	@Override
	public InterestRate minus(MathContext mathContext, UnitAmount<BigDecimalAmount, InterestRateUnit> other) {
		return new InterestRate(minusAmount(mathContext, other), getUnit());
	}

	@Override
	public InterestRate multipliedBy(MathContext mathContext, BigDecimal other) {
		return new InterestRate(multipliedByAmount(mathContext, other), getUnit());
	}

	@Override
	public InterestRate dividedBy(MathContext mathContext, BigDecimal other) {
		return new InterestRate(dividedByAmount(mathContext, other), getUnit());
	}

	// endregion
}
