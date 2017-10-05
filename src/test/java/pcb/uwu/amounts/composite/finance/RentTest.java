package pcb.uwu.amounts.composite.finance;

import org.junit.Test;
import pcb.uwu.amounts.fundamental.Money;
import pcb.uwu.amounts.fundamental.Time;

import java.util.Currency;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.units.composite.finance.InterestRateUnit.PER_WEEK;
import static pcb.uwu.units.fundamental.TimeUnit.DAY;

public class RentTest {
	private Money money = new Money(6, Currency.getInstance("GBP"));
	private Time time = new Time(3, DAY);
	private InterestRate interestRate = new InterestRate(0.2, PER_WEEK);

	@Test
	public void testFromMoneyAndTime() {
		assertEquals("2.00£/d", money.dividedBy(time, DECIMAL64).toString());
		assertEquals("1.200£/wk", money.multipliedBy(interestRate, DECIMAL64).toString());

		System.err.println(interestRate.getClass().getComponentType());
	}
}
