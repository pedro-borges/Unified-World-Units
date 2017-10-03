package pcb.units.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectCounterTest {
	@Test
	public void testObjectCounter() {
		ObjectCounter<Integer> test = new ObjectCounter<>();

		assertEquals(0, test.get(1));
		assertEquals(1, (test = test.major(1)).get(1));
		assertEquals(0, (test = test.minor(1)).get(1));
		assertEquals(-1, (test = test.minor(1)).get(1));
		assertEquals(0, (test = test.major(1)).get(1));
		assertEquals(1, (test = test.major(1)).get(1));
		assertEquals(1, (test = test.major(2)).get(2));
		assertEquals(2, (test = test.major(1)).get(1));
		assertEquals(3, (test = test.major(1)).get(1));
		assertEquals(-1, (test = test.minor(3)).get(3));
		assertEquals(1, test.getNegativeKeys().size());
		assertEquals(3, test.getNegativeKeys().get(0).intValue());
		assertEquals(2, test.getPositiveKeys().size());
		assertEquals(1, test.getPositiveKeys().get(0).intValue());
		assertEquals(2, test.getPositiveKeys().get(1).intValue());
		assertEquals(0, (test = test.major(3)).get(3));
		assertEquals(0, test.getNegativeKeys().size());
		assertEquals(2, test.getPositiveKeys().size());
		assertEquals(1, test.getPositiveKeys().get(0).intValue());
		assertEquals(2, test.getPositiveKeys().get(1).intValue());
	}
}
