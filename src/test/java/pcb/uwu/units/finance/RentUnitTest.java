package pcb.uwu.units.finance;

import org.junit.Test;
import pcb.uwu.units.composite.finance.InterestRateUnit;
import pcb.uwu.units.composite.finance.RentUnit;
import pcb.uwu.units.fundamental.MoneyUnit;
import pcb.uwu.units.fundamental.TimeUnit;

import java.util.Currency;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.units.fundamental.TimeUnit.DAY;
import static pcb.uwu.units.fundamental.TimeUnit.WEEK;

public class RentUnitTest {
	private final MoneyUnit money = new MoneyUnit(Currency.getInstance("GBP"));
	private final TimeUnit time = DAY;
	private final InterestRateUnit interestRate = new InterestRateUnit(WEEK);

	@Test
	public void testConstructFromMoneyAndTime() {
		assertEquals("£/d", new RentUnit(money, time).getSymbol());
		assertEquals("£/wk", new RentUnit(money, interestRate).getSymbol());
	}
}
