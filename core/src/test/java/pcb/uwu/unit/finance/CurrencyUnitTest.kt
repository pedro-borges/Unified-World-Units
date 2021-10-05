package pcb.uwu.unit.finance;

import org.junit.Test;
import pcb.uwu.exception.InvalidCurrencyException;

import java.util.Currency;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ZERO;

public class MoneyUnitTest {
	public static final MoneyUnit GBP = new MoneyUnit(Currency.getInstance("GBP"));

	// region test constructors

	@Test
	public void testCurrencyEquals() {
		assertSame(Currency.getInstance("GBP"), GBP.getCurrency());
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testConstructorCurrency() {
		assertEquals("£", GBP.toString());

		GBP.getTranslationToCanonical().apply(ZERO);
	}

	// endregion
}