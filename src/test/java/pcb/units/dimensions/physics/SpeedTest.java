package pcb.units.dimensions.physics;

import org.junit.Test;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.composite.physics.Speed;
import pcb.units.concrete.space.Meters;
import pcb.units.concrete.time.Seconds;
import pcb.units.dimensions.space.Space;
import pcb.units.dimensions.time.Time;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;

public class SpeedTest {
	@Test
	public void testCreateFromSpaceAndTime() {
		Space<BigDecimalAmount> space = new Meters<>(new BigDecimalAmount(10));
		Time time = new Seconds(new BigDecimalAmount(2));

		Speed speed = Speed.create(DECIMAL64, space, time);

		assertEquals(new BigDecimalAmount(5), speed.getAmount());
		assertEquals("m/s", speed.getUnit().getSymbol());
	}
}