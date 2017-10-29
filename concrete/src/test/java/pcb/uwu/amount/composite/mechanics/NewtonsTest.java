package pcb.uwu.amount.composite.mechanics;

import org.junit.Test;
import pcb.uwu.units.composite.mechanics.ForceUnit;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.composite.mechanics.NewtonUnit.NEWTON;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class NewtonsTest {
	@Test
	public void testConstruct() {
		ForceUnit unit = new ForceUnit(KILOGRAM, METER, SECOND, SECOND);
		Newtons newtons = new Newtons(2);

		assertEquals("2 N", newtons.toString());
		assertEquals("2 Kgm/s²", newtons.convertTo(unit).toString());

		Force force = new Force(2.2, unit);

		assertEquals("2.2 N", force.convertTo(NEWTON).toString());
	}
}