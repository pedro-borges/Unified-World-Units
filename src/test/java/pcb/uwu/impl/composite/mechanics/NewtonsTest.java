package pcb.uwu.impl.composite.mechanics;

import org.junit.Test;
import pcb.uwu.units.composite.mechanics.ForceUnit;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.MAJOR_MAGNITUDES;
import static pcb.uwu.units.fundamental.LengthUnit.METER;
import static pcb.uwu.units.fundamental.MassUnit.GRAM;
import static pcb.uwu.units.fundamental.TimeUnit.SECOND;

public class NewtonsTest {
	@Test
	public void testConstruct() {
		Newtons newtons = new Newtons(2);

		assertEquals("2N", newtons.toString());
		assertEquals("2Kgm/s²", newtons.convertTo(new ForceUnit(GRAM, METER, SECOND, SECOND)).toStringWithMagnitude(MAJOR_MAGNITUDES));
	}
}