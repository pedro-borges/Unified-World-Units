package pcb.units.concrete;

import org.junit.Test;
import pcb.units.concrete.imperial.Inches;
import pcb.units.concrete.si.Meters;

import java.math.MathContext;

public class MetersTest {
	@Test
	public void testConvertToInches() {
		Meters meters = new Meters(1);

		meters.plus(new Inches(2), MathContext.DECIMAL64);
	}
}
