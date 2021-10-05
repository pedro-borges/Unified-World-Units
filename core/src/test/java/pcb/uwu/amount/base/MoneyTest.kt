package pcb.uwu.amount.base;

import org.junit.Test;
import pcb.uwu.amount.finance.Money;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.exception.InvalidCurrencyException;
import pcb.uwu.unit.finance.MoneyUnit;

import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;

public class MoneyTest {
	private static final MoneyUnit GBP = MoneyUnit.of("GBP");
	private static final MoneyUnit USD = MoneyUnit.of("USD");

	// region test constructors

	@Test
	public void testConstructHonoursDefaultFractionDigits() {
		assertConstructors(new Money("1.005", GBP));
		assertConstructors(new Money("0.995", GBP));
	}

	private void assertConstructors(Money money) {
		assertEquals(GBP.getDefaultFractionDigits(), money.getAmount().getScale());
		assertEquals(new BigDecimalAmount("1.00"), money.getAmount());
	}

	// endregion

	@Test
	public void testPlusSameCurrency() {
		Money money1 = new Money(1, GBP);
		Money money2 = new Money(10, GBP);

		assertEquals(new Money(11, GBP), money1.plus(money2, UNLIMITED));
	}

	@Test(expected = InvalidCurrencyException.class)
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

	@Test(expected = InvalidCurrencyException.class)
	public void testMinusDifferentCurrency() {
		Money money1 = new Money(1, GBP);
		Money money2 = new Money(10, USD);

		money1.minus(money2, UNLIMITED);
	}
}