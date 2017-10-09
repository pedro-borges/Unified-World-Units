package pcb.uwu.amount.composite.mechanics;

import org.junit.Test;
import pcb.uwu.units.composite.mechanics.ForceUnit;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.composite.mechanics.NewtonUnit.NEWTON;
import static pcb.uwu.unit.quantity.GramUnit.GRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class NewtonsTest {
	@Test
	public void testConstruct() {
		ForceUnit unit = new ForceUnit(GRAM, METER, SECOND, SECOND);
		Newtons newtons = new Newtons(2);

		assertEquals("2N", newtons.toString());
		assertEquals("2000gm/s²", newtons.convertTo(unit).toString());

		Force force = new Force(2200, unit);

		assertEquals("2.2N", force.convertTo(NEWTON).toString());
	}
}