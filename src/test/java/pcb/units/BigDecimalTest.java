package pcb.units;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BigDecimalTest {
	@Test
	public void testMovePointAndScale() {
		BigDecimal value = new BigDecimal("12.34");

		assertEquals(2, value.scale());

		assertEquals(new BigDecimal("1.234"), value.movePointLeft(1));
		assertEquals(3, value.movePointLeft(1).scale());
		assertEquals(new BigDecimal("123.4"), value.movePointRight(1));
		assertEquals(1, value.movePointRight(1).scale());
	}
}
