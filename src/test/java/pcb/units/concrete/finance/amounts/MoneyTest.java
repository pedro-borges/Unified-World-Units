package pcb.units.concrete.finance.amounts;

import org.junit.Test;
import pcb.units.amount.Amount;

import java.util.Currency;

import static java.math.BigDecimal.ONE;
import static org.junit.Assert.assertEquals;

public class MoneyTest {
	private static final Currency GBP = Currency.getInstance("GBP");

	@Test
	public void testConstructCurrencyBigDecimal() {
		Money money = new Money(ONE, GBP);

		assertEquals(GBP.getDefaultFractionDigits(), money.getAmount().getScale());
		assertEquals(GBP, money.getUnit().getCurrency());
		assertEquals(new Amount("1.00"), money.getAmount());
	}
}