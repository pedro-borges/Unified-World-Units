package pcb.uwu.amount.composite.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.composite.fundamental.Area;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.composite.fundamental.SquareMeterUnit.SQUARE_METER;

public class TeslasTest {
	private static final Teslas teslas = new Teslas(2);

	@Test
	public void multipliedByArea() {
		assertEquals(new Webbers(4),
				teslas.multipliedBy(new Area(2, SQUARE_METER), DECIMAL64));
	}

}