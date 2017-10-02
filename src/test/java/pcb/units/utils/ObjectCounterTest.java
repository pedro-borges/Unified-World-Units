package pcb.units.utils;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ObjectCounterTest {
	@Test
	public void testObjectCounter() {
		ObjectCounter<Integer> test = new ObjectCounter<>();

		assertEquals(0, test.get(1));
		assertEquals(1, (test = test.increase(1)).get(1));
		assertEquals(0, (test = test.decrease(1)).get(1));
		assertEquals(-1, (test = test.decrease(1)).get(1));
		assertEquals(0, (test = test.increase(1)).get(1));
		assertEquals(1, (test = test.increase(1)).get(1));
		assertEquals(1, (test = test.increase(2)).get(2));
		assertEquals(2, (test = test.increase(1)).get(1));
		assertEquals(3, (test = test.increase(1)).get(1));
		assertEquals(-1, (test = test.decrease(3)).get(3));
		assertEquals(1, test.getNegativeKeys(asList(1, 2, 3)).size());
		assertEquals(3, test.getNegativeKeys(asList(1, 2, 3)).get(0).intValue());
		assertEquals(2, test.getPositiveKeys(asList(1, 2, 3)).size());
		assertEquals(1, test.getPositiveKeys(asList(1, 2, 3)).get(0).intValue());
		assertEquals(2, test.getPositiveKeys(asList(1, 2, 3)).get(1).intValue());
		assertEquals(0, (test = test.increase(3)).get(3));
		assertEquals(0, test.getNegativeKeys(asList(1, 2, 3)).size());
		assertEquals(2, test.getPositiveKeys(asList(1, 2, 3)).size());
		assertEquals(2, test.getPositiveKeys(asList(3, 2, 1)).get(0).intValue());
		assertEquals(1, test.getPositiveKeys(asList(3, 2, 1)).get(1).intValue());
	}
}
