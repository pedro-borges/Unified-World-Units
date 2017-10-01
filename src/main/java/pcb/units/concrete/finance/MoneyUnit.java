package pcb.units.concrete.finance;

import com.sun.istack.internal.Nullable;
import pcb.units.amount.Amount;
import pcb.units.base.BaseUnit;
import pcb.units.dimensions.finance.CurrencyUnit;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL32;

public class MoneyUnit
		extends BaseUnit<MoneyUnit>
		implements CurrencyUnit {

	public static final Currency CANONICAL_CURRENCY = Currency.getInstance("USD");

	// region private fields

	private final Currency currency;
	private final CurrencyConversionProvider currencyConversionProvider;

	// endregion

	// region constructors

	public MoneyUnit(Currency currency) {
		this(currency, null);
	}

	public MoneyUnit(Currency currency, @Nullable CurrencyConversionProvider currencyConversionProvider) {
		super(currency.getSymbol(),
				currency.getDisplayName(),
				currency.getDisplayName(),
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); },
				ignored -> { throw new InvalidCurrencyException("Cannot convert currencies"); });

		this.currency = currency;
		this.currencyConversionProvider = currencyConversionProvider;
	}

	// endregion

	// region implement CurrencyUnit

	@Override
	public Currency getCurrency() {
		return currency;
	}

	@Override
	public Function<Amount, Amount> getTranslationToCanonical() {
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
	public Function<Amount, Amount> getTranslationFromCanonical() {
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
