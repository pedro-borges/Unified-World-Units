package pcb.units.amount;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static pcb.units.amount.Magnitude.CENTI;
import static pcb.units.amount.Magnitude.DECA;
import static pcb.units.amount.Magnitude.DECI;
import static pcb.units.amount.Magnitude.GIGA;
import static pcb.units.amount.Magnitude.HECTA;
import static pcb.units.amount.Magnitude.KILO;
import static pcb.units.amount.Magnitude.MEGA;
import static pcb.units.amount.Magnitude.MICRO;
import static pcb.units.amount.Magnitude.MILI;
import static pcb.units.amount.Magnitude.NANO;
import static pcb.units.amount.Magnitude.NATURAL;
import static pcb.units.amount.Magnitude.PICO;
import static pcb.units.amount.Magnitude.TERA;

public class MagnitudeTest {
	@Test
	public void testValues() {
		assertEquals(new BigDecimal("1000000000000"), TERA.getValue());
		assertEquals(new BigDecimal("1000000000"), GIGA.getValue());
		assertEquals(new BigDecimal("1000000"), MEGA.getValue());
		assertEquals(new BigDecimal("1000"), KILO.getValue());
		assertEquals(new BigDecimal("100"), HECTA.getValue());
		assertEquals(new BigDecimal("10"), DECA.getValue());
		assertEquals(new BigDecimal("1"), NATURAL.getValue());
		assertEquals(new BigDecimal("0.1"), DECI.getValue());
		assertEquals(new BigDecimal("0.01"), CENTI.getValue());
		assertEquals(new BigDecimal("0.001"), MILI.getValue());
		assertEquals(new BigDecimal("0.000001"), MICRO.getValue());
		assertEquals(new BigDecimal("0.000000001"), NANO.getValue());
		assertEquals(new BigDecimal("0.000000000001"), PICO.getValue());
	}
}
