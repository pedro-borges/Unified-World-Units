package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.units.quantity.ElectricCurrentUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

import static org.junit.Assert.assertEquals;

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
		assertEquals(3, test.getPowers().size());
		assertEquals(-1, test.get(KILOGRAM));
		assertEquals(3, test.get(SECOND));
		assertEquals(1, test.get(AMPERE));
		assertEquals(0, (test = test.major(KILOGRAM)).get(KILOGRAM));
		assertEquals(2, test.getPowers().size());
		assertEquals(3, test.get(SECOND));
		assertEquals(1, test.get(AMPERE));
	}

	@Test
	public void testFindMajorUnit() {
		UnitCounter test = new UnitCounter()
				.major(SECOND)
				.major(AMPERE)
				.major(KILOGRAM);

		assertEquals(SECOND, test.findUnit(TimeUnit.class));
		assertEquals(AMPERE, test.findUnit(ElectricCurrentUnit.class));
		assertEquals(KILOGRAM, test.findUnit(MassUnit.class));
	}
}
