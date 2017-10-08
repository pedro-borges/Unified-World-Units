package pcb.uwu.impl.composite.fundamental;

import org.junit.Test;
import pcb.uwu.amounts.composite.fundamental.Volume;
import pcb.uwu.units.composite.fundamental.VolumeUnit;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.units.composite.fundamental.VolumeUnit.LITRE;
import static pcb.uwu.units.fundamental.LengthUnit.METER;

public class LitresTest {
	@Test
	public void testConstruct() {
		VolumeUnit unit = new VolumeUnit(METER, METER, METER);
		Litres litres = new Litres(1);

		assertEquals("1l", litres.toString());
		assertEquals("0.001m³", litres.convertTo(unit).toString());

		Volume volume = new Volume(3.03, unit);

		assertEquals("3030.00l", volume.convertTo(LITRE).toString());
	}
}