package pcb.uwu.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilsTest {
	@Test
	public void max() {
		assertEquals(5, MathUtils.max(4, 1, 5, 3).intValue());
		assertEquals(-1, MathUtils.max(-4, -1, -5, -3).intValue());
	}

	@Test
	public void min() {
		assertEquals(1, MathUtils.min(4, 1, 5, 3).intValue());
		assertEquals(-5, MathUtils.min(-4, -1, -5, -3).intValue());
	}
}