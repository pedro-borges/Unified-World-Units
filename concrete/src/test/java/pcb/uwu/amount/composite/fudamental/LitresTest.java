package pcb.uwu.amount.composite.fudamental;

import org.junit.Assert;
import org.junit.Test;
import pcb.uwu.amount.composite.fundamental.Litres;
import pcb.uwu.amount.composite.fundamental.Volume;
import pcb.uwu.units.composite.fundamental.VolumeUnit;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.composite.fundamental.LitreUnit.LITRE;
import static pcb.uwu.unit.quantity.MeterUnit.METER;

public class LitresTest {
	@Test
	public void testConstruct() {
		VolumeUnit unit = new VolumeUnit(METER, METER, METER) {};
		Litres litres = new Litres(1);

		assertEquals("1l", litres.toString());
		assertEquals("0.001m³", litres.convertTo(unit).toString());

		Volume volume = new Volume(3.03, unit);

		Assert.assertEquals("3030.00l", volume.convertTo(LITRE).toString());
	}
}