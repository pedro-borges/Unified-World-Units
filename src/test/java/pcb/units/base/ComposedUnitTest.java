package pcb.units.base;

import org.junit.Test;
import pcb.units.concrete.fundamental.imperial.InchUnit;
import pcb.units.concrete.fundamental.si.MinuteUnit;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;

public class ComposedUnitTest {
	private static final ComposedUnit inchesPerSquareMinute = new ComposedUnit()
			.multipliedBy(new InchUnit())
			.dividedBy(new MinuteUnit())
			.dividedBy(new MinuteUnit());

	@Test
	public void testSymbol() {
		assertEquals("in/min²", inchesPerSquareMinute.getSymbol());
	}

	@Test
	public void testSingularName() {
		assertEquals("inch per minute²", inchesPerSquareMinute.getSingularName());
	}

	@Test
	public void testPluralName() {
		assertEquals("inches per minute²", inchesPerSquareMinute.getPluralName());
	}

	@Test
	public void testTranslationToCanonical() {
		assertEquals(new BigDecimal("0.0000070556"), inchesPerSquareMinute.getTranslationToCanonical()
				.apply(new BigDecimal(1))
				.setScale(10, HALF_EVEN));
	}

	@Test
	public void testTranslationFromCanonical() {
		assertEquals(new BigDecimal("141732.2834645669"), inchesPerSquareMinute.getTranslationFromCanonical()
				.apply(new BigDecimal(1))
				.setScale(10, HALF_EVEN));
	}

	@Test
	public void testBuildPower() {
		ComposedUnit composedUnit = new ComposedUnit();

		assertEquals("⁻¹¹", composedUnit.buildPower(-11));
		assertEquals("⁻¹⁰", composedUnit.buildPower(-10));
		assertEquals("⁻⁹", composedUnit.buildPower(-9));
		assertEquals("⁻¹", composedUnit.buildPower(-1));
		assertEquals("⁰", composedUnit.buildPower(0));
		assertEquals("", composedUnit.buildPower(1));
		assertEquals("⁹", composedUnit.buildPower(9));
		assertEquals("¹⁰", composedUnit.buildPower(10));
		assertEquals("¹¹", composedUnit.buildPower(11));
	}
}