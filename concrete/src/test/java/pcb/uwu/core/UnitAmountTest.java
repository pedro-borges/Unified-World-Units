package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.amount.quantity.Length;
import pcb.uwu.amount.quantity.Meters;
import pcb.uwu.amount.quantity.Minutes;
import pcb.uwu.amount.quantity.Seconds;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.amount.quantity.Yards;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class UnitAmountTest {
	private static final Length meters = new Meters(1);
	private static final Time seconds = new Seconds(1);
	private static final Length yards = new Yards(1);
	private static final Time minutes = new Minutes(1);

	@Test
	public void testMultiplyByMajor() {
		CompositeUnitAmount<? extends Unit> one = seconds.dividedBy(meters, DECIMAL64);
		CompositeUnitAmount<? extends Unit> two = minutes.dividedBy(yards, DECIMAL64);

		CompositeUnitAmount<? extends Unit> result = one.multipliedBy(two, DECIMAL64);
		UnitCounter resultUnitCounter = result.getUnit().getUnitCounter();

		assertEquals(1, result.getAmount().getValue().intValueExact());
		assertEquals(4, resultUnitCounter.getPowers().size());
		assertEquals(1, resultUnitCounter.get(seconds.getUnit()));
		assertEquals(1, resultUnitCounter.get(minutes.getUnit()));
		assertEquals(-1, resultUnitCounter.get(meters.getUnit()));
		assertEquals(-1, resultUnitCounter.get(yards.getUnit()));
	}
}
