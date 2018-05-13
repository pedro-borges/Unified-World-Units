package pcb.uwu.amount.finance;

import org.junit.Test;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.finance.InterestRate;
import pcb.uwu.unit.finance.InterestRateUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.DayUnit.DAY;
import static pcb.uwu.unit.base.WeekUnit.WEEK;

public class RentTest {
	private GBP gbp = new GBP(6);
	private Time time = new Time(3, DAY);
	private InterestRate interestRate = new InterestRate(0.2, new InterestRateUnit(WEEK));

	@Test
	public void testFromMoneyAndTime() {
		assertEquals("2.00 £⋅d⁻¹", gbp.dividedBy(time, DECIMAL64).toString());
		assertEquals("1.200 £⋅wk⁻¹", gbp.multipliedBy(interestRate, DECIMAL64).toString());
	}
}
