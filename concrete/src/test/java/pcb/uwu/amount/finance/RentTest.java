package pcb.uwu.amount.finance;

import org.junit.Test;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.finance.InterestRate;
import pcb.uwu.amount.derived.finance.Rent;
import pcb.uwu.unit.finance.InterestRateUnit;
import pcb.uwu.unit.finance.RentUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MILLI;
import static pcb.uwu.unit.base.DayUnit.DAY;
import static pcb.uwu.unit.base.WeekUnit.WEEK;

public class RentTest {
	private GBP gbp = new GBP(6);
	private Time time = new Time(3, DAY);
	private InterestRate interestRate = new InterestRate(0.2, new InterestRateUnit(WEEK));

	@Test
	public void testFromMoneyAndTime() {
		assertEquals(new Rent(2, new RentUnit(gbp.getUnit(), time.getUnit())),
				gbp.dividedBy(time, DECIMAL64));
		assertEquals(new Rent(1200, MILLI, new RentUnit(gbp.getUnit(), interestRate.getUnit())),
				gbp.multipliedBy(interestRate, DECIMAL64));
	}
}
