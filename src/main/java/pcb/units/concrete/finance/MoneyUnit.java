package pcb.units.concrete.finance;

import pcb.units.amount.Amount;
import pcb.units.base.Unit;

import java.util.Currency;
import java.util.function.Function;

public class MoneyUnit
		implements Unit {

	private final Currency currency;

	public MoneyUnit(Currency currency) {
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public String getSymbol() {
		return currency.getSymbol();
	}

	@Override
	public String getSingularName() {
		return currency.getDisplayName();
	}

	@Override
	public String getPluralName() {
		return currency.getDisplayName();
	}

	@Override
	public Function<Amount, Amount> translationToCanonical() {
		throw new CurrencyMismatchException("Cannot convert currencies");
	}

	@Override
	public Function<Amount, Amount> translationFromCanonical() {
		throw new CurrencyMismatchException("Cannot convert currencies");
	}
}
