package pcb.uwu.amounts.composite.fundamental;

import org.junit.Test;
import pcb.uwu.core.BigDecimalAmount;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.units.composite.fundamental.AreaUnit.SQUARE_FOOT;
import static pcb.uwu.units.composite.fundamental.AreaUnit.SQUARE_METER;

public class AreaTest {
	@Test
	public void testTranslation() {
		Area area = new Area(1, SQUARE_FOOT);

		assertEquals(new BigDecimalAmount("0.09290304"), area.convertTo(SQUARE_METER).getAmount());
	}
}