package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.impl.fundamental.Amperes;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.ALL_MAGNITUDES;
import static pcb.uwu.core.Magnitude.CENTI;
import static pcb.uwu.core.Magnitude.DECI;
import static pcb.uwu.core.Magnitude.DEKA;
import static pcb.uwu.core.Magnitude.GIGA;
import static pcb.uwu.core.Magnitude.HECTA;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MEGA;
import static pcb.uwu.core.Magnitude.MICRO;
import static pcb.uwu.core.Magnitude.MILLI;
import static pcb.uwu.core.Magnitude.NANO;
import static pcb.uwu.core.Magnitude.NATURAL;
import static pcb.uwu.core.Magnitude.PICO;
import static pcb.uwu.core.Magnitude.TERA;

public class MagnitudeTest {
	@Test
	public void testValues() {
		assertEquals(new BigDecimal("1000000000000"), TERA.getValue());
		assertEquals(new BigDecimal("1000000000"), GIGA.getValue());
		assertEquals(new BigDecimal("1000000"), MEGA.getValue());
		assertEquals(new BigDecimal("1000"), KILO.getValue());
		assertEquals(new BigDecimal("100"), HECTA.getValue());
		assertEquals(new BigDecimal("10"), DEKA.getValue());
		assertEquals(new BigDecimal("1"), NATURAL.getValue());
		assertEquals(new BigDecimal("0.1"), DECI.getValue());
		assertEquals(new BigDecimal("0.01"), CENTI.getValue());
		assertEquals(new BigDecimal("0.001"), MILLI.getValue());
		assertEquals(new BigDecimal("0.000001"), MICRO.getValue());
		assertEquals(new BigDecimal("0.000000001"), NANO.getValue());
		assertEquals(new BigDecimal("0.000000000001"), PICO.getValue());
	}

	@Test
	public void testAmountUnits() {
		assertEquals("1T", new Amperes(1, TERA).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1G", new Amperes(1, GIGA).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1M", new Amperes(1, MEGA).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1K", new Amperes(1, KILO).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1H", new Amperes(1, HECTA).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1D", new Amperes(1, DEKA).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1", new Amperes(1, NATURAL).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1d", new Amperes(1, DECI).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1c", new Amperes(1, CENTI).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1m", new Amperes(1, MILLI).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1μ", new Amperes(1, MICRO).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1n", new Amperes(1, NANO).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
		assertEquals("1p", new Amperes(1, PICO).getAmount().toStringWithMagnitude(ALL_MAGNITUDES));
	}

	@Test
	public void testHugeAmountUnits() {
		BigDecimal ONE_BILLION = new BigDecimal("1000000000000");

		assertEquals(new BigDecimal("1000000000000000000000000"), new Amperes(ONE_BILLION, TERA).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000000000000"), new Amperes(ONE_BILLION, GIGA).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000000000"), new Amperes(ONE_BILLION, MEGA).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000000"), new Amperes(ONE_BILLION, KILO).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("100000000000000"), new Amperes(ONE_BILLION, HECTA).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("10000000000000"), new Amperes(ONE_BILLION, DEKA).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000"), new Amperes(ONE_BILLION, NATURAL).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("100000000000"), new Amperes(ONE_BILLION, DECI).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("10000000000"), new Amperes(ONE_BILLION, CENTI).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000"), new Amperes(ONE_BILLION, MILLI).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000"), new Amperes(ONE_BILLION, MICRO).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000"), new Amperes(ONE_BILLION, NANO).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1"), new Amperes(ONE_BILLION, PICO).getAmount().getValue().setScale(0, HALF_EVEN));
	}

	@Test
	public void testTinyAmountUnits() {
		BigDecimal ONE_BILLIONTH = new BigDecimal("0.000000000001");

		assertEquals(new BigDecimal("1"), new Amperes(ONE_BILLIONTH, TERA).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("0.001"), new Amperes(ONE_BILLIONTH, GIGA).getAmount().getValue().setScale(3, HALF_EVEN));
		assertEquals(new BigDecimal("0.000001"), new Amperes(ONE_BILLIONTH, MEGA).getAmount().getValue().setScale(6, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000001"), new Amperes(ONE_BILLIONTH, KILO).getAmount().getValue().setScale(9, HALF_EVEN));
		assertEquals(new BigDecimal("0.0000000001"), new Amperes(ONE_BILLIONTH, HECTA).getAmount().getValue().setScale(10, HALF_EVEN));
		assertEquals(new BigDecimal("0.00000000001"), new Amperes(ONE_BILLIONTH, DEKA).getAmount().getValue().setScale(11, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000001"), new Amperes(ONE_BILLIONTH, NATURAL).getAmount().getValue().setScale(12, HALF_EVEN));
		assertEquals(new BigDecimal("0.0000000000001"), new Amperes(ONE_BILLIONTH, DECI).getAmount().getValue().setScale(13, HALF_EVEN));
		assertEquals(new BigDecimal("0.00000000000001"), new Amperes(ONE_BILLIONTH, CENTI).getAmount().getValue().setScale(14, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000001"), new Amperes(ONE_BILLIONTH, MILLI).getAmount().getValue().setScale(15, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000000001"), new Amperes(ONE_BILLIONTH, MICRO).getAmount().getValue().setScale(18, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000000000001"), new Amperes(ONE_BILLIONTH, NANO).getAmount().getValue().setScale(21, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000000000000001"), new Amperes(ONE_BILLIONTH, PICO).getAmount().getValue().setScale(24, HALF_EVEN));
	}
}
