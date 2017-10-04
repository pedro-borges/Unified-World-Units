package pcb.units.concrete.finance;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.finance.Currency;
import pcb.units.dimensions.finance.CurrencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_EVEN;

public class Money
		extends AbstractUnitAmount<BigDecimalAmount, CurrencyUnit>
		implements Currency {

	// region constructors

	public Money(Number value, java.util.Currency currency) {
		this(value.toString(), currency);
	}

	public Money(String value, java.util.Currency currency) {
		this(new BigDecimal(value), currency);
	}

	public Money(BigDecimal value, java.util.Currency currency) {
		this(new BigDecimalAmount(value), currency);
	}

	public Money(BigDecimalAmount amount, java.util.Currency currency) {
		this(amount, new MoneyUnit(currency));
	}

	public Money(BigDecimalAmount amount, CurrencyUnit unit) {
		super(amount.withScale(unit.getCurrency().getDefaultFractionDigits(), HALF_EVEN), unit);
	}

	// endregion

	//region implement UnitAmount

	@Override
	public Money plus(MathContext mathContext, UnitAmount<BigDecimalAmount, CurrencyUnit> other) {
		throwIfDistinctCurrency(other);

		return new Money(getAmount().plus(other.getAmount(), mathContext), getUnit());
	}

	@Override
	public Money minus(MathContext mathContext, UnitAmount<BigDecimalAmount, CurrencyUnit> other) {
		throwIfDistinctCurrency(other);

		return new Money(getAmount().minus(other.getAmount(), mathContext), getUnit());
	}

	@Override
	public Money multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Money(getAmount().multipliedBy(other, mathContext), getUnit());
	}

	@Override
	public Money dividedBy(MathContext mathContext, BigDecimal other) {
		return new Money(getAmount().dividedBy(other, mathContext), getUnit());
	}

	@Override
	public BigDecimalAmount getAmountIn(CurrencyUnit newUnit) {
		if (getUnit().getCurrency().equals(newUnit.getCurrency())) {
			return getAmount();
		}

		throw new CurrencyMismatchException("Unable to convert {} to {}", getUnit().getCurrency(), newUnit.getCurrency());
	}

	// endregion

	// region private methods

	private void throwIfDistinctCurrency(UnitAmount<BigDecimalAmount, CurrencyUnit> other) {
		if (!getUnit().getCurrency().equals(other.getUnit().getCurrency())) {
			throw new CurrencyMismatchException("Cant add {} to {}", other.getUnit().getPluralName(), getUnit().getPluralName());
		}
	}

	// endregion
}
