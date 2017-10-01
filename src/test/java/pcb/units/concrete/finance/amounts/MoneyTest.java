package pcb.units.concrete.finance.amounts;

import org.junit.Test;
import pcb.units.amount.Amount;
import pcb.units.concrete.finance.CurrencyMismatchException;
import pcb.units.concrete.finance.MoneyUnit;

import java.util.Currency;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;

public class MoneyTest {
	private static final Currency GBP = Currency.getInstance("GBP");
	private static final Currency USD = Currency.getInstance("USD");

	// region test constructors

	@Test
	public void testConstructNumberCurrency() {
		assertConstructors(new Money(1, GBP));
	}

	@Test
	public void testConstructStringCurrency() {
		assertConstructors(new Money("1", GBP));
	}

	@Test
	public void testConstructBigDecimalCurrency() {
		assertConstructors(new Money(ONE, GBP));
	}

	@Test
	public void testConstructAmountCurrency() {
		assertConstructors(new Money(new Amount(1), GBP));
	}

	@Test
	public void testConstructAmountMoneyUnit() {
		assertConstructors(new Money(new Amount(1), new MoneyUnit(GBP)));
	}

	@Test
	public void testConstructHonoursDefaultFractionDigits() {
		assertConstructors(new Money("1.005", GBP));
		assertConstructors(new Money("0.995", GBP));
	}

	private void assertConstructors(Money money) {
		assertEquals(GBP.getDefaultFractionDigits(), money.getAmount().getScale());
		assertEquals(GBP, money.getUnit().getCurrency());
		assertEquals(new Amount("1.00"), money.getAmount());
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

	@Test
	public void testDivideBySameCurrency() {
		Money money1 = new Money(10, GBP);
		Money money2 = new Money(5, GBP);

		assertEquals(new Amount(2), money1.dividedBy(money2, UNLIMITED));
	}

	@Test(expected = CurrencyMismatchException.class)
	public void testDividedByDifferentCurrency() {
		Money money1 = new Money(10, GBP);
		Money money2 = new Money(5, USD);

		money1.dividedBy(money2, UNLIMITED);
	}
}