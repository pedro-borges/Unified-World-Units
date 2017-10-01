package pcb.units.concrete.finance;

import org.junit.Test;
import pcb.units.amount.Amount;

import java.math.BigDecimal;
import java.util.Currency;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.DECIMAL32;
import static java.math.RoundingMode.HALF_EVEN;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static pcb.units.concrete.finance.MoneyUnit.CANONICAL_CURRENCY;

public class MoneyUnitTest {
	private static final Currency GBP = Currency.getInstance("GBP");

	// region test constructors

	@Test
	public void testCurrencyEquals() {
		assertTrue(Currency.getInstance("GBP") == GBP);
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testConstructorCurrency() {
		MoneyUnit moneyUnit = new MoneyUnit(GBP);

		assertEquals(GBP, moneyUnit.getCurrency());

		moneyUnit.getTranslationToCanonical().apply(new Amount(0));
	}

	@Test
	public void testConstructorCurrencyConverterWithConversion() {
		CurrencyConversionProvider currencyConversionProvider = (originalCurrency, destinationCurrency) ->
		{
			if (originalCurrency == GBP && destinationCurrency == CANONICAL_CURRENCY) return new BigDecimal("1.1");
			if (originalCurrency == CANONICAL_CURRENCY && destinationCurrency == GBP) return ONE.divide(new BigDecimal("1.1"), DECIMAL32);

			return null;
		};

		MoneyUnit moneyUnit = new MoneyUnit(GBP, currencyConversionProvider);

		assertEquals(GBP, moneyUnit.getCurrency());

		Amount result;

		result = moneyUnit.getTranslationToCanonical().apply(new Amount("100.00"));
		assertEquals(new BigDecimal("110.00"), result.getValue().setScale(2, HALF_EVEN));
		result = moneyUnit.getTranslationFromCanonical().apply(new Amount("110.00"));
		assertEquals(new BigDecimal("100.00"), result.getValue().setScale(2, HALF_EVEN));
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testConstructorCurrencyConverterWithNoConversion() {
		CurrencyConversionProvider currencyConversionProvider = (originalCurrency, destinationCurrency) -> null;

		MoneyUnit moneyUnit = new MoneyUnit(GBP, currencyConversionProvider);

		assertEquals(GBP, moneyUnit.getCurrency());

		moneyUnit.getTranslationToCanonical().apply(new Amount(0));
	}

	// endregion
}