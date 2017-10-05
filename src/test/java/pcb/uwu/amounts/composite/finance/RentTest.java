package pcb.uwu.amounts.composite.finance;

import org.junit.Test;
import pcb.uwu.amounts.fundamental.Money;
import pcb.uwu.amounts.fundamental.Time;
import pcb.uwu.units.composite.finance.InterestRateUnit;

import java.util.Currency;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.units.fundamental.TimeUnit.DAY;
import static pcb.uwu.units.fundamental.TimeUnit.WEEK;

public class RentTest {
	private Money money = new Money(6, Currency.getInstance("GBP"));
	private Time time = new Time(3, DAY);
	private InterestRate interestRate = new InterestRate(2, new InterestRateUnit(WEEK));

	@Test
	public void testFromMoneyAndTime() {
		assertEquals("2.00£/d", money.dividedBy(time, DECIMAL64).toString());
		assertEquals("12.00£/wk", money.multipliedBy(interestRate, DECIMAL64).toString());
	}
}
