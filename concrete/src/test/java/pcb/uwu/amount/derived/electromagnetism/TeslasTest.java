package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.derived.area.Area;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUAREMETER;

public class TeslasTest {
	private static final Teslas teslas = new Teslas(2);

	@Test
	public void multipliedByArea() {
		assertEquals(new Webbers(4),
				teslas.multipliedBy(new Area(2, SQUAREMETER), DECIMAL64));
	}

}