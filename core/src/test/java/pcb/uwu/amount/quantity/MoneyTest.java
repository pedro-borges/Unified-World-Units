package pcb.uwu.amount.quantity;

import org.junit.Test;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.exceptions.CurrencyMismatchException;

import java.util.Currency;

import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;

public class MoneyTest {
	private static final Currency GBP = Currency.getInstance("GBP");
	private static final Currency USD = Currency.getInstance("USD");

	// region test constructors

	@Test
	public void testConstructHonoursDefaultFractionDigits() {
		assertConstructors(new Money("1.005", GBP));
		assertConstructors(new Money("0.995", GBP));
	}

	private void assertConstructors(Money money) {
		assertEquals(GBP.getDefaultFractionDigits(), money.getAmount().getScale());
		assertEquals(GBP, money.getUnit().getCurrency());
		assertEquals(new BigDecimalAmount("1.00"), money.getAmount());
	}

	// endregion

	@Test
	public void testPlusSameCurrency() {
		Money money1 = new Money(1, GBP);
		Money money2 = new Money(10, GBP);

		assertEquals(new Money(11, GBP), money1.plus(money2, UNLIMITED));
	}

	@Test(expected = CurrencyMismatchException.class)
	public void testPlusDifferentCurrency() {
		Money money1 = new Money(1, GBP);
		Money money2 = new Money(10, USD);

		money1.plus(money2, UNLIMITED);
	}

	@Test
	public void testMinusSameCurrency() {
		Money money1 = new Money(1, GBP);
		Money money2 = new Money(10, GBP);

		assertEquals(new Money(-9, GBP), money1.minus(money2, UNLIMITED));
	}

	@Test(expected = CurrencyMismatchException.class)
	public void testMinusDifferentCurrency() {
		Money money1 = new Money(1, GBP);
		Money money2 = new Money(10, USD);

		money1.minus(money2, UNLIMITED);
	}
}