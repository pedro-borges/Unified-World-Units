package pcb.uwu.amount.base;

import pcb.uwu.amount.finance.InterestRate;
import pcb.uwu.amount.finance.Rent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.exceptions.CurrencyMismatchException;
import pcb.uwu.units.finance.MoneyUnit;
import pcb.uwu.units.finance.RentUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

import static java.math.RoundingMode.HALF_EVEN;

public class Money extends CompositeUnitAmount<MoneyUnit> {

	// region constructors

	public Money(Number value, Currency currency) {
		this(value.toString(), currency);
	}

	public Money(String value, Currency currency) {
		this(new BigDecimal(value), currency);
	}

	public Money(BigDecimal value, Currency currency) {
		this(new BigDecimalAmount(value), currency);
	}

	public Money(BigDecimalAmount amount, Currency currency) {
		this(amount, new MoneyUnit(currency));
	}

	public Money(BigDecimalAmount amount, MoneyUnit unit) {
		super(amount.withScale(unit.getCurrency().getDefaultFractionDigits(), HALF_EVEN), unit);
	}

	// endregion

	// region private methods

	private void throwIfDistinctCurrency(UnitAmount<MoneyUnit> other) {
		if (!getUnit().getCurrency().equals(other.getUnit().getCurrency())) {
			throw new CurrencyMismatchException("Cant add {} to {}", other.getUnit().getPluralName(), getUnit().getPluralName());
		}
	}

	// endregion

	//region implement UnitAmount

	@Override
	public Money plus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		throwIfDistinctCurrency(other);

		return new Money(getAmount().plus(other.getAmount(), mathContext), getUnit());
	}

	@Override
	public Money minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		throwIfDistinctCurrency(other);

		return new Money(getAmount().minus(other.getAmount(), mathContext), getUnit());
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
	public BigDecimalAmount getAmountIn(MoneyUnit newUnit) {
		if (getUnit().getCurrency().equals(newUnit.getCurrency())) {
			return getAmount();
		}

		throw new CurrencyMismatchException("Unable to convert {} to {}", getUnit().getCurrency(), newUnit.getCurrency());
	}

	@Override
	public Money convertTo(MoneyUnit unit) {
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
