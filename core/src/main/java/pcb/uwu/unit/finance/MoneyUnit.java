package pcb.uwu.unit.finance;

import pcb.uwu.contract.CurrencyConversionProvider;
import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.exception.InvalidCurrencyException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL32;

public class MoneyUnit extends BaseUnit {

	public static final Currency CANONICAL_CURRENCY = Currency.getInstance("USD");

	// region private fields

	private final Currency currency;
	private final CurrencyConversionProvider currencyConversionProvider;
	private final UnitCounter unitCounter;

	// endregion

	// region constructors

	public MoneyUnit(Currency currency) {
		this(currency, null);
	}

	public MoneyUnit(Currency currency, CurrencyConversionProvider currencyConversionProvider) {
		super(100,
				currency.getSymbol(),
				currency.getDisplayName(),
				currency.getDisplayName(),
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); },
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); });

		this.currency = currency;
		this.unitCounter = new UnitCounter(this);
		this.currencyConversionProvider = currencyConversionProvider;
	}

	public static MoneyUnit of(String code) {
		return new MoneyUnit(Currency.getInstance(code));
	}

	// endregion

	// region implement Unit

	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical() {
		if (currencyConversionProvider == null) {
			return super.getTranslationToCanonical();
		}

		BigDecimal ratio = currencyConversionProvider.getRatio(currency, CANONICAL_CURRENCY);

		if (ratio == null) {
			throw new InvalidCurrencyException("No ratio available to convert {} to {}",
					currency.getDisplayName(), CANONICAL_CURRENCY.getDisplayName());
		}

		return amount -> amount.multipliedBy(ratio, DECIMAL32);
	}

	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical() {
		if (currencyConversionProvider == null) {
			return super.getTranslationToCanonical();
		}

		BigDecimal ratio = currencyConversionProvider.getRatio(CANONICAL_CURRENCY, currency);

		if (ratio == null) {
			throw new InvalidCurrencyException("No ratio available to convert {} to {}",
					CANONICAL_CURRENCY.getDisplayName(), currency.getDisplayName());
		}

		return amount -> amount.multipliedBy(ratio, DECIMAL32);
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
