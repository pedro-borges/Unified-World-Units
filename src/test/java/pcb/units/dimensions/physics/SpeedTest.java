package pcb.units.dimensions.physics;

import org.junit.Test;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.concrete.fundamental.si.Meters;
import pcb.units.concrete.fundamental.si.Seconds;
import pcb.units.dimensions.fundamental.Space;
import pcb.units.dimensions.fundamental.Time;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class SpeedTest {
	@Test
	public void testCreateFromSpaceAndTime() {
		Space<BigDecimalAmount> space = new Meters<>(new BigDecimalAmount(10));
		Time<BigDecimalAmount> time = new Seconds<>(new BigDecimalAmount(2));

		Speed speed = Speed.create(DECIMAL64, space, time);

		assertEquals(new BigDecimalAmount(5), speed.getAmount());
		assertEquals("m/s", speed.getUnit().getSymbol());
	}
}