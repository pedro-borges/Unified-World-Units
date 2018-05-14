package pcb.uwu.unit.finance;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.exception.InvalidCurrencyException;

import java.util.Currency;
import java.util.Objects;
import java.util.function.Function;

public class MoneyUnit extends BaseUnit {

	public static final MoneyUnit CANONICAL_CURRENCY = new MoneyUnit(Currency.getInstance("USD"));

	// region private fields

	private final Currency currency;
	private final UnitCounter unitCounter;

	// endregion

	// region constructors

	public MoneyUnit(Currency currency) {
		super(100,
				currency.getSymbol(),
				currency.getDisplayName(),
				currency.getDisplayName(),
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); },
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); });

		this.currency = currency;
		this.unitCounter = new UnitCounter(this);
	}

	public static MoneyUnit of(String code) {
		return new MoneyUnit(Currency.getInstance(code));
	}

	// endregion

	// region implement Unit

	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical() {
		throw new InvalidCurrencyException("Dynamic currency conversion is not possible");
	}

	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical() {
		throw new InvalidCurrencyException("Dynamic currency conversion is not possible");
	}

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return MoneyUnit.class;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return unitCounter;
	}

	// endregion

	// region public methods

	public Currency getCurrency() {
		return currency;
	}

	public int getDefaultFractionDigits() {
		return currency.getDefaultFractionDigits();
	}

	// endregion

	// region overload Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MoneyUnit) {
			MoneyUnit that = (MoneyUnit) obj;

			return Objects.equals(this.currency, that.currency);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return currency.hashCode();
	}

	// endregion
}
