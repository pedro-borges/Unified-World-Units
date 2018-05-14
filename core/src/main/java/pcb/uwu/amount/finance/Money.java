package pcb.uwu.amount.finance;

import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.finance.InterestRate;
import pcb.uwu.amount.derived.finance.Rent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;
import pcb.uwu.unit.finance.RentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_EVEN;

public class Money extends CompositeUnitAmount<MoneyUnit> {

	// region constructors

	public Money(Number value, MoneyUnit unit) {
		this(value.toString(), unit);
	}

	public Money(String value, MoneyUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Money(BigDecimal value, MoneyUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Money(BigDecimalAmount amount, MoneyUnit unit) {
		super(amount.withScale(unit.getDefaultFractionDigits(), HALF_EVEN), unit);
	}

	// endregion

	//region implement UnitAmount

	@Override
	public Money plus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new Money(getAmount().plus(other.getAmountIn(getUnit()), mathContext), getUnit());
	}

	@Override
	public Money minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new Money(getAmount().minus(other.getAmountIn(getUnit()), mathContext), getUnit());
	}

	@Override
	public Money multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Money(getAmount().multipliedBy(other, mathContext), getUnit());
	}

	@Override
	public Money dividedBy(BigDecimal other, MathContext mathContext) {
		return new Money(getAmount().dividedBy(other, mathContext), getUnit());
	}

	@Override
	public Money in(MoneyUnit unit) {
		return new Money(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public Rent dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.dividedBy(time.getAmount().getValue(), mathContext);
		RentUnit unit = new RentUnit(getUnit(), time.getUnit());

		return new Rent(amount, unit);
	}

	public Rent multipliedBy(InterestRate interestRate, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.multipliedBy(interestRate.getAmount().getValue(), mathContext);
		RentUnit unit = new RentUnit(getUnit(), interestRate.getUnit());

		return new Rent(amount, unit);
	}

	// endregion
}
