package pcb.uwu.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pcb.uwu.units.fundamental.ElectricCurrentUnit.AMPERE;
import static pcb.uwu.units.fundamental.MassUnit.GRAM;
import static pcb.uwu.units.fundamental.TimeUnit.SECOND;

public class UnitCounterTest {
	@Test
	public void testObjectCounter() {
		UnitCounter test = new UnitCounter();

		assertEquals(0, test.get(SECOND));
		assertEquals(1, (test = test.major(SECOND)).get(SECOND));
		assertEquals(0, (test = test.minor(SECOND)).get(SECOND));
		assertEquals(-1, (test = test.minor(SECOND)).get(SECOND));
		assertEquals(0, (test = test.major(SECOND)).get(SECOND));
		assertEquals(1, (test = test.major(SECOND)).get(SECOND));
		assertEquals(1, (test = test.major(AMPERE)).get(AMPERE));
		assertEquals(2, (test = test.major(SECOND)).get(SECOND));
		assertEquals(3, (test = test.major(SECOND)).get(SECOND));
		assertEquals(-1, (test = test.minor(GRAM)).get(GRAM));
		assertEquals(1, test.getNegativeKeys().size());
		assertTrue(test.getNegativeKeys().contains(GRAM));
		assertEquals(2, test.getPositiveKeys().size());
		assertTrue(test.getPositiveKeys().contains(SECOND));
		assertTrue(test.getPositiveKeys().contains(AMPERE));
		assertEquals(0, (test = test.major(GRAM)).get(GRAM));
		assertEquals(0, test.getNegativeKeys().size());
		assertEquals(2, test.getPositiveKeys().size());
		assertTrue(test.getPositiveKeys().contains(SECOND));
		assertTrue(test.getPositiveKeys().contains(AMPERE));
	}
}
