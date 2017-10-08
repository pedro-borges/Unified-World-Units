package pcb.uwu.amounts.composite.fundamental;

import org.junit.Test;
import pcb.uwu.core.BigDecimalAmount;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.units.composite.fundamental.VolumeUnit.CUBIC_FOOT;
import static pcb.uwu.units.composite.fundamental.VolumeUnit.CUBIC_METER;

public class VolumeTest {
	@Test
	public void testTranslation() {
		Volume volume = new Volume(1, CUBIC_FOOT);

		assertEquals(new BigDecimalAmount("0.028316846592"), volume.convertTo(CUBIC_METER).getAmount());
	}
}