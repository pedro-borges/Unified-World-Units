package pcb.uwu.unit.finance;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.exception.InvalidCurrencyException;

import java.util.Currency;
import java.util.Objects;
import java.util.function.Function;

public class CurrencyUnit extends BaseUnit {

	public static final CurrencyUnit CANONICAL_CURRENCY = new CurrencyUnit(Currency.getInstance("USD"));
	public static final CurrencyUnit GBP = CurrencyUnit.of("GBP");
	public static final CurrencyUnit USD = CurrencyUnit.of("USD");
	public static final CurrencyUnit EUR = CurrencyUnit.of("EUR");

	// region private fields

	private final Currency currency;
	private final UnitCounter unitCounter;

	// endregion

	// region constructors

	public CurrencyUnit(Currency currency) {
		super(100,
				currency.getSymbol(),
				currency.getDisplayName(),
				currency.getDisplayName(),
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); },
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); });

		this.currency = currency;
		this.unitCounter = new UnitCounter(this);
	}

	public static CurrencyUnit of(String code) {
		return new CurrencyUnit(Currency.getInstance(code));
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
		return CurrencyUnit.class;
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
		if (obj instanceof CurrencyUnit) {
			CurrencyUnit that = (CurrencyUnit) obj;

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
