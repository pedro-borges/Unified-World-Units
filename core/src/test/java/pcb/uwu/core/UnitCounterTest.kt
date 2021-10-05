package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UnitCounterTest {
	public static final BaseUnit SECOND = new TimeUnit("s", "", "", null, null) {};
	public static final BaseUnit AMPERE = new ElectricCurrentUnit("A", "", "", null, null) {};
	public static final BaseUnit KILOGRAM = new MassUnit("Kg", "", "", null, null) {};

	@Test
	public void testObjectCounter() {
		UnitCounter test = new UnitCounter();

		assertEquals(0, test.get(SECOND).getCount());
		assertEquals(1, (test = test.major(SECOND)).get(SECOND).getCount());
		assertEquals(0, (test = test.minor(SECOND)).get(SECOND).getCount());
		assertEquals(-1, (test = test.minor(SECOND)).get(SECOND).getCount());
		assertEquals(0, (test = test.major(SECOND)).get(SECOND).getCount());
		assertEquals(1, (test = test.major(SECOND)).get(SECOND).getCount());
		assertEquals(1, (test = test.major(AMPERE)).get(AMPERE).getCount());
		assertEquals(2, (test = test.major(SECOND)).get(SECOND).getCount());
		assertEquals(3, (test = test.major(SECOND)).get(SECOND).getCount());
		assertEquals(-1, (test = test.minor(KILOGRAM)).get(KILOGRAM).getCount());
		assertEquals(3, test.getBaseUnits().size());
		assertEquals(-1, test.get(KILOGRAM).getCount());
		assertEquals(3, test.get(SECOND).getCount());
		assertEquals(1, test.get(AMPERE).getCount());
		assertEquals(0, (test = test.major(KILOGRAM)).get(KILOGRAM).getCount());
		assertEquals(2, test.getBaseUnits().size());
		assertEquals(3, test.get(SECOND).getCount());
		assertEquals(1, test.get(AMPERE).getCount());
	}
}
