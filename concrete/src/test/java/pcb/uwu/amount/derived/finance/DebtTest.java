package pcb.uwu.amount.derived.finance;

import org.junit.Test;
import pcb.uwu.amount.base.Weeks;
import pcb.uwu.amount.finance.USD;
import pcb.uwu.unit.derived.finance.DebtUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.WeekUnit.WEEK;
import static pcb.uwu.unit.derived.fundamental.PerDayUnit.PER_DAY;

public class DebtTest {
	public static final Debt debt = new Debt(60, new DebtUnit(USD.CURRENCY, WEEK));

	@Test
	public void multipliedByInterestRate() {
		InterestRate interestRate = new InterestRate("0.2", PER_DAY);

		assertEquals("84.00 USD", debt.multipliedBy(interestRate, DECIMAL64).toString());
	}

	@Test
	public void dividedByTime() {
		Weeks weeks = new Weeks(2);

		assertEquals("30.00 USD", debt.dividedBy(weeks, DECIMAL64).toString());
	}

	@Test
	public void dividedByMoney() {
		USD money = new USD(20);

		assertEquals("3.00 wk", debt.dividedBy(money, DECIMAL64).toString());
	}
}
