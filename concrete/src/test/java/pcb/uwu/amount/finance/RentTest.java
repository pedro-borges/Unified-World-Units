package pcb.uwu.amount.finance;

import org.junit.Test;
import pcb.uwu.amount.quantity.Money;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.units.finance.InterestRateUnit;
import pcb.uwu.units.finance.RentUnit;

import java.util.Currency;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;
import static pcb.uwu.unit.quantity.DayUnit.DAY;
import static pcb.uwu.unit.quantity.WeekUnit.WEEK;

public class RentTest {
	private Money money = new Money(6, Currency.getInstance("GBP"));
	private Time time = new Time(3, DAY);
	private InterestRate interestRate = new InterestRate(0.2, new InterestRateUnit(WEEK));

	@Test
	public void testFromMoneyAndTime() {
		assertEquals(new Rent(2, new RentUnit(money.getUnit(), time.getUnit())),
				money.dividedBy(time, DECIMAL64));
		assertEquals(new Rent(1200, MILLI, new RentUnit(money.getUnit(), interestRate.getUnit())),
				money.multipliedBy(interestRate, DECIMAL64));
	}
}
