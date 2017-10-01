package pcb.units.concrete.finance.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.finance.CurrencyMismatchException;
import pcb.units.concrete.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

import static java.math.RoundingMode.HALF_EVEN;

public class Money
		extends AbstractUnitAmount<MoneyUnit>
		implements UnitAmount<MoneyUnit> {

	// region constructors

	public Money(Number value, Currency currency) {
		this(value.toString(), currency);
	}

	public Money(String value, Currency currency) {
		this(new BigDecimal(value), currency);
	}

	public Money(BigDecimal value, Currency currency) {
		this(new Amount(value), currency);
	}
	
	public Money(Amount amount, Currency currency) {
		this(amount, new MoneyUnit(currency));
	}

	public Money(Amount amount, MoneyUnit unit) {
		super(amount.withScale(unit.getCurrency().getDefaultFractionDigits(), HALF_EVEN), unit);
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
	public Money multipliedBy(Amount other, MathContext mathContext) {
		return new Money(getAmount().multipliedBy(other.getValue(), mathContext), getUnit());
	}

	@Override
	public Money dividedBy(Amount other, MathContext mathContext) {
		return new Money(getAmount().dividedBy(other.getValue(), mathContext), getUnit());
	}

	@Override
	public Amount dividedBy(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		throwIfDistinctCurrency(other);

		return getAmount().dividedBy(other.getAmount(), mathContext);
	}

	@Override
	public Amount getAmountIn(MoneyUnit newUnit) {
		if (getUnit().getCurrency().equals(newUnit.getCurrency())) {
			return getAmount();
		}

		throw new CurrencyMismatchException("Unable to convert {} to {}", getUnit().getCurrency(), newUnit.getCurrency());
	}

	// endregion

	// region private methods

	private void throwIfDistinctCurrency(UnitAmount<MoneyUnit> other) {
		if (!getUnit().getCurrency().equals(other.getUnit().getCurrency())) {
			throw new CurrencyMismatchException("Cant add {} to {}", other.getUnit().getPluralName(), getUnit().getPluralName());
		}
	}

	// endregion
}
