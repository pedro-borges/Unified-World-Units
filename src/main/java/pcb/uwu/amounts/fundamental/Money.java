package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.exceptions.CurrencyMismatchException;
import pcb.uwu.units.fundamental.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

import static java.math.RoundingMode.HALF_EVEN;

public class Money
		extends AbstractUnitAmount<BigDecimalAmount, MoneyUnit>
		implements UnitAmount<BigDecimalAmount, MoneyUnit> {

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

	//region implement UnitAmount

	@Override
	public Money plus(UnitAmount<BigDecimalAmount, MoneyUnit> other, MathContext mathContext) {
		throwIfDistinctCurrency(other);

		return new Money(getAmount().plus(other.getAmount(), mathContext), getUnit());
	}

	@Override
	public Money minus(UnitAmount<BigDecimalAmount, MoneyUnit> other, MathContext mathContext) {
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

	// endregion

	// region private methods

	private void throwIfDistinctCurrency(UnitAmount<BigDecimalAmount, MoneyUnit> other) {
		if (!getUnit().getCurrency().equals(other.getUnit().getCurrency())) {
			throw new CurrencyMismatchException("Cant add {} to {}", other.getUnit().getPluralName(), getUnit().getPluralName());
		}
	}

	// endregion
}