package pcb.units.concrete.finance.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.concrete.finance.CurrencyMismatchException;
import pcb.units.concrete.finance.MoneyUnit;
import pcb.units.dimensions.finance.CurrencyUnit;
import pcb.units.dimensions.finance.amounts.Currency;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_EVEN;

public class Money<A extends Amount<A>>
		extends AbstractUnitAmount<A, CurrencyUnit>
		implements Currency<A> {

	// region constructors

	public Money(A amount, java.util.Currency currency) {
		this(amount, new MoneyUnit(currency));
	}

	public Money(A amount, CurrencyUnit unit) {
		super(amount.withScale(unit.getCurrency().getDefaultFractionDigits(), HALF_EVEN), unit);
	}

	// endregion

	//region implement UnitAmount

	@Override
	public Money<A> plus(UnitAmount<A, CurrencyUnit> other, MathContext mathContext) {
		throwIfDistinctCurrency(other);

		return new Money<>(getAmount().plus(other.getAmount(), mathContext), getUnit());
	}

	@Override
	public Money<A> minus(UnitAmount<A, CurrencyUnit> other, MathContext mathContext) {
		throwIfDistinctCurrency(other);

		return new Money<>(getAmount().minus(other.getAmount(), mathContext), getUnit());
	}

	@Override
	public Money<A> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Money<>(getAmount().multipliedBy(other, mathContext), getUnit());
	}

	@Override
	public Money<A> dividedBy(BigDecimal other, MathContext mathContext) {
		return new Money<>(getAmount().dividedBy(other, mathContext), getUnit());
	}

	@Override
	public A getAmountIn(CurrencyUnit newUnit) {
		if (getUnit().getCurrency().equals(newUnit.getCurrency())) {
			return getAmount();
		}

		throw new CurrencyMismatchException("Unable to convert {} to {}", getUnit().getCurrency(), newUnit.getCurrency());
	}

	// endregion

	// region private methods

	private void throwIfDistinctCurrency(UnitAmount<A, CurrencyUnit> other) {
		if (!getUnit().getCurrency().equals(other.getUnit().getCurrency())) {
			throw new CurrencyMismatchException("Cant add {} to {}", other.getUnit().getPluralName(), getUnit().getPluralName());
		}
	}

	// endregion
}
