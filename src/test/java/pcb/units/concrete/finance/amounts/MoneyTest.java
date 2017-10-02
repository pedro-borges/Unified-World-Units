package pcb.units.concrete.finance.amounts;

import org.junit.Test;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.concrete.finance.CurrencyMismatchException;
import pcb.units.concrete.finance.MoneyUnit;

import java.math.BigDecimal;
import java.util.Currency;

import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;

public class MoneyTest {
	private static final Currency GBP = Currency.getInstance("GBP");
	private static final Currency USD = Currency.getInstance("USD");

	// region test constructors

	@Test
	public void testConstructAmountCurrency() {
		assertConstructors(new Money<>(new BigDecimalAmount(1), GBP));
	}

	@Test
	public void testConstructAmountMoneyUnit() {
		assertConstructors(new Money<>(new BigDecimalAmount(1), new MoneyUnit(GBP)));
	}

	@Test
	public void testConstructHonoursDefaultFractionDigits() {
		assertConstructors(new Money<>(new BigDecimalAmount("1.005"), GBP));
		assertConstructors(new Money<>(new BigDecimalAmount("0.995"), GBP));
	}

	private void assertConstructors(Money<BigDecimalAmount> money) {
		assertEquals(GBP.getDefaultFractionDigits(), money.getAmount().getScale());
		assertEquals(GBP, money.getUnit().getCurrency());
		assertEquals(new BigDecimalAmount("1.00"), money.getAmount());
	}

	// endregion

	@Test
	public void testPlusSameCurrency() {
		Money<BigDecimalAmount> money1 = new Money<>(new BigDecimalAmount(1), GBP);
		Money<BigDecimalAmount> money2 = new Money<>(new BigDecimalAmount(10), GBP);

		assertEquals(new Money<>(new BigDecimalAmount(11), GBP), money1.plus(money2, UNLIMITED));
	}

	@Test(expected = CurrencyMismatchException.class)
	public void testPlusDifferentCurrency() {
		Money<BigDecimalAmount> money1 = new Money<>(new BigDecimalAmount(1), GBP);
		Money<BigDecimalAmount> money2 = new Money<>(new BigDecimalAmount(10), USD);

		money1.plus(money2, UNLIMITED);
	}

	@Test
	public void testMinusSameCurrency() {
		Money<BigDecimalAmount> money1 = new Money<>(new BigDecimalAmount(1), GBP);
		Money<BigDecimalAmount> money2 = new Money<>(new BigDecimalAmount(10), GBP);

		assertEquals(new Money<>(new BigDecimalAmount(-9), GBP), money1.minus(money2, UNLIMITED));
	}

	@Test(expected = CurrencyMismatchException.class)
	public void testMinusDifferentCurrency() {
		Money<BigDecimalAmount> money1 = new Money<>(new BigDecimalAmount(1), GBP);
		Money<BigDecimalAmount> money2 = new Money<>(new BigDecimalAmount(10), USD);

		money1.minus(money2, UNLIMITED);
	}

	@Test
	public void testDivideBySameCurrency() {
		Money<BigDecimalAmount> money1 = new Money<>(new BigDecimalAmount(10), GBP);
		Money<BigDecimalAmount> money2 = new Money<>(new BigDecimalAmount(5), GBP);

		assertEquals(new BigDecimal(2), money1.dividedBy(money2, UNLIMITED));
	}

	@Test(expected = CurrencyMismatchException.class)
	public void testDividedByDifferentCurrency() {
		Money<BigDecimalAmount> money1 = new Money<>(new BigDecimalAmount(10), GBP);
		Money<BigDecimalAmount> money2 = new Money<>(new BigDecimalAmount(5), USD);

		money1.dividedBy(money2, UNLIMITED);
	}
}