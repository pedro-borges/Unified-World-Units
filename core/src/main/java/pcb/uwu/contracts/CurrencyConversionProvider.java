package pcb.uwu.contracts;

import java.math.BigDecimal;
import java.util.Currency;

@FunctionalInterface
public interface CurrencyConversionProvider {
	BigDecimal getRatio(Currency originalCurrency, Currency destinationCurrency);
}
