package pcb.uwu.amount.derived.fudamental;

import org.junit.Assert;
import org.junit.Test;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.amount.derived.fundamental.volume.Litres;
import pcb.uwu.unit.derived.fundamental.VolumeUnit;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.CENTI;
import static pcb.uwu.core.Magnitude.DECI;
import static pcb.uwu.core.Magnitude.MILLI;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.derived.fundamental.LitreUnit.LITRE;

public class LitresTest {
	@Test
	public void construct() {
		VolumeUnit cubicMeter = new VolumeUnit(METER, METER, METER) {};
		Litres litres = new Litres(1);

		assertEquals("1 l", litres.toString());
		assertEquals("0.001 m³", litres.in(cubicMeter).toString());

		Volume volume = new Volume(3.03, cubicMeter);

		Assert.assertEquals("3030.00 l", volume.in(LITRE).toString());
	}

	@Test
	public void sphereFactory() {
		Litres ball;

		ball = Litres.FOR.sphereWithRadius(new Meters(10, MILLI), DECIMAL64);
		assertEquals("0.004188790204786390 l", ball.toString());

		ball = Litres.FOR.sphereWithRadius(new Meters(10, CENTI), DECIMAL64);
		assertEquals("4.188790204786390 l", ball.toString());

		ball = Litres.FOR.sphereWithRadius(new Meters(10, DECI), DECIMAL64);
		assertEquals("4188.790204786390 l", ball.toString());
	}

	@Test
	public void cubeFactory() {
		Litres cube;

		cube = Litres.FOR.cubeWithSide(new Meters(1, CENTI), DECIMAL64);
		assertEquals("0.001 l", cube.toString());

		cube = Litres.FOR.cubeWithSide(new Meters(1, DECI), DECIMAL64);
		assertEquals("1 l", cube.toString());

		cube = Litres.FOR.cubeWithSide(new Meters(1), DECIMAL64);
		assertEquals("1000 l", cube.toString());
	}
}