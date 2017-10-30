package pcb.uwu.amount.derived.fudamental;

import org.junit.Assert;
import org.junit.Test;
import pcb.uwu.amount.derived.fundamental.Litres;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.units.derived.fundamental.VolumeUnit;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.derived.fundamental.LitreUnit.LITRE;

public class LitresTest {
	@Test
	public void testConstruct() {
		VolumeUnit unit = new VolumeUnit(METER, METER, METER) {};
		Litres litres = new Litres(1);

		assertEquals("1 l", litres.toString());
		assertEquals("0.001 m³", litres.convertTo(unit).toString());

		Volume volume = new Volume(3.03, unit);

		Assert.assertEquals("3030.00 l", volume.convertTo(LITRE).toString());
	}
}