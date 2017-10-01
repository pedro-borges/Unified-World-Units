package pcb.units.concrete.finance;

import pcb.units.base.BaseUnit;
import pcb.units.base.Unit;

import java.util.Currency;
import java.util.Objects;

public class MoneyUnit
		extends BaseUnit<MoneyUnit>
		implements Unit {

	// region private fields

	private final Currency currency;

	// endregion

	// region constructors

	public MoneyUnit(Currency currency) {
		super(currency.getSymbol(),
				currency.getDisplayName(),
				currency.getDisplayName(),
				ignored -> { throw new CurrencyMismatchException("Cannot convert currencies"); },
				ignored -> { throw new CurrencyMismatchException("Cannot convert currencies"); });

		this.currency = currency;
	}

	// todo add constructor with supplier of currency converter

	// endregion

	// region properties

	public Currency getCurrency() {
		return currency;
	}

	// endregion

	// region overload Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MoneyUnit) {
			MoneyUnit other = (MoneyUnit) obj;

			return Objects.equals(this.currency, other.currency);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return currency.hashCode();
	}

	// endregion
}
