package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.amounts.fundamental.ElectricCurrent;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.CENTI;
import static pcb.uwu.core.Magnitude.DECA;
import static pcb.uwu.core.Magnitude.DECI;
import static pcb.uwu.core.Magnitude.GIGA;
import static pcb.uwu.core.Magnitude.HECTA;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MEGA;
import static pcb.uwu.core.Magnitude.MICRO;
import static pcb.uwu.core.Magnitude.MILI;
import static pcb.uwu.core.Magnitude.NANO;
import static pcb.uwu.core.Magnitude.NATURAL;
import static pcb.uwu.core.Magnitude.PICO;
import static pcb.uwu.core.Magnitude.TERA;
import static pcb.uwu.units.fundamental.ElectricCurrentUnit.AMPERE;

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

	@Test
	public void testAmountUnits() {
		assertEquals(new BigDecimal("1000000000000"), new ElectricCurrent(1, TERA, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("1000000000"), new ElectricCurrent(1, GIGA, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("1000000"), new ElectricCurrent(1, MEGA, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("1000"), new ElectricCurrent(1, KILO, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("100"), new ElectricCurrent(1, HECTA, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("10"), new ElectricCurrent(1, DECA, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("1"), new ElectricCurrent(1, NATURAL, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("0.1"), new ElectricCurrent(1, DECI, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("0.01"), new ElectricCurrent(1, CENTI, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("0.001"), new ElectricCurrent(1, MILI, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("0.000001"), new ElectricCurrent(1, MICRO, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("0.000000001"), new ElectricCurrent(1, NANO, AMPERE).getAmount().getValue());
		assertEquals(new BigDecimal("0.000000000001"), new ElectricCurrent(1, PICO, AMPERE).getAmount().getValue());
	}

	@Test
	public void testHugeAmountUnits() {
		BigDecimal ONE_BILLION = new BigDecimal("1000000000000");

		assertEquals(new BigDecimal("1000000000000000000000000"), new ElectricCurrent(ONE_BILLION, TERA, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000000000000"), new ElectricCurrent(ONE_BILLION, GIGA, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000000000"), new ElectricCurrent(ONE_BILLION, MEGA, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000000"), new ElectricCurrent(ONE_BILLION, KILO, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("100000000000000"), new ElectricCurrent(ONE_BILLION, HECTA, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("10000000000000"), new ElectricCurrent(ONE_BILLION, DECA, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000000"), new ElectricCurrent(ONE_BILLION, NATURAL, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("100000000000"), new ElectricCurrent(ONE_BILLION, DECI, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("10000000000"), new ElectricCurrent(ONE_BILLION, CENTI, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000000"), new ElectricCurrent(ONE_BILLION, MILI, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000000"), new ElectricCurrent(ONE_BILLION, MICRO, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1000"), new ElectricCurrent(ONE_BILLION, NANO, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("1"), new ElectricCurrent(ONE_BILLION, PICO, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
	}

	@Test
	public void testTinyAmountUnits() {
		BigDecimal ONE_BILLIONTH = new BigDecimal("0.000000000001");

		assertEquals(new BigDecimal("1"), new ElectricCurrent(ONE_BILLIONTH, TERA, AMPERE).getAmount().getValue().setScale(0, HALF_EVEN));
		assertEquals(new BigDecimal("0.001"), new ElectricCurrent(ONE_BILLIONTH, GIGA, AMPERE).getAmount().getValue().setScale(3, HALF_EVEN));
		assertEquals(new BigDecimal("0.000001"), new ElectricCurrent(ONE_BILLIONTH, MEGA, AMPERE).getAmount().getValue().setScale(6, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000001"), new ElectricCurrent(ONE_BILLIONTH, KILO, AMPERE).getAmount().getValue().setScale(9, HALF_EVEN));
		assertEquals(new BigDecimal("0.0000000001"), new ElectricCurrent(ONE_BILLIONTH, HECTA, AMPERE).getAmount().getValue().setScale(10, HALF_EVEN));
		assertEquals(new BigDecimal("0.00000000001"), new ElectricCurrent(ONE_BILLIONTH, DECA, AMPERE).getAmount().getValue().setScale(11, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000001"), new ElectricCurrent(ONE_BILLIONTH, NATURAL, AMPERE).getAmount().getValue().setScale(12, HALF_EVEN));
		assertEquals(new BigDecimal("0.0000000000001"), new ElectricCurrent(ONE_BILLIONTH, DECI, AMPERE).getAmount().getValue().setScale(13, HALF_EVEN));
		assertEquals(new BigDecimal("0.00000000000001"), new ElectricCurrent(ONE_BILLIONTH, CENTI, AMPERE).getAmount().getValue().setScale(14, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000001"), new ElectricCurrent(ONE_BILLIONTH, MILI, AMPERE).getAmount().getValue().setScale(15, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000000001"), new ElectricCurrent(ONE_BILLIONTH, MICRO, AMPERE).getAmount().getValue().setScale(18, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000000000001"), new ElectricCurrent(ONE_BILLIONTH, NANO, AMPERE).getAmount().getValue().setScale(21, HALF_EVEN));
		assertEquals(new BigDecimal("0.000000000000000000000001"), new ElectricCurrent(ONE_BILLIONTH, PICO, AMPERE).getAmount().getValue().setScale(24, HALF_EVEN));
	}
}
