package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.units.quantity.ElectricCurrentUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitCounterTest {
	public static final BaseUnit SECOND = new TimeUnit("s", "", "", null, null) {};
	public static final BaseUnit AMPERE = new ElectricCurrentUnit("A", "", "", null, null) {};
	public static final BaseUnit KILOGRAM = new MassUnit("Kg", "", "", null, null) {};

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
		assertEquals(-1, (test = test.minor(KILOGRAM)).get(KILOGRAM));
		assertEquals(1, test.getNegativeKeys().size());
		assertTrue(test.getNegativeKeys().contains(KILOGRAM));
		assertEquals(2, test.getPositiveKeys().size());
		assertTrue(test.getPositiveKeys().contains(SECOND));
		assertTrue(test.getPositiveKeys().contains(AMPERE));
		assertEquals(0, (test = test.major(KILOGRAM)).get(KILOGRAM));
		assertEquals(0, test.getNegativeKeys().size());
		assertEquals(2, test.getPositiveKeys().size());
		assertTrue(test.getPositiveKeys().contains(SECOND));
		assertTrue(test.getPositiveKeys().contains(AMPERE));
	}

	@Test
	public void testFindMajorUnit() {
		UnitCounter test = new UnitCounter()
				.major(SECOND)
				.major(AMPERE)
				.major(KILOGRAM);

		assertEquals(SECOND, test.findMajorUnit(TimeUnit.class));
		assertEquals(AMPERE, test.findMajorUnit(ElectricCurrentUnit.class));
		assertEquals(KILOGRAM, test.findMajorUnit(MassUnit.class));
	}
}
