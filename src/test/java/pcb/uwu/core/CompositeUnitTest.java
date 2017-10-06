package pcb.uwu.core;

import org.junit.Test;

import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ONE;
import static pcb.uwu.units.fundamental.LengthUnit.INCH;
import static pcb.uwu.units.fundamental.TimeUnit.MINUTE;

public class CompositeUnitTest {
	private static final CompositeUnit inchesPerSquareMinute = new CompositeUnit()
			.major(INCH)
			.minor(MINUTE)
			.minor(MINUTE);

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
		assertEquals(new BigDecimalAmount("0.0000070556"), inchesPerSquareMinute.getTranslationToCanonical()
				.apply(ONE)
				.withScale(10, HALF_EVEN));
	}

	@Test
	public void testTranslationFromCanonical() {
		assertEquals(new BigDecimalAmount("141732.2834645669"), inchesPerSquareMinute.getTranslationFromCanonical()
				.apply(ONE)
				.withScale(10, HALF_EVEN));
	}

	@Test
	public void testBuildPower() {
		CompositeUnit compositeUnit = new CompositeUnit();

		assertEquals("⁻¹¹", compositeUnit.buildPower(-11));
		assertEquals("⁻¹⁰", compositeUnit.buildPower(-10));
		assertEquals("⁻⁹", compositeUnit.buildPower(-9));
		assertEquals("⁻¹", compositeUnit.buildPower(-1));
		assertEquals("⁰", compositeUnit.buildPower(0));
		assertEquals("", compositeUnit.buildPower(1));
		assertEquals("⁹", compositeUnit.buildPower(9));
		assertEquals("¹⁰", compositeUnit.buildPower(10));
		assertEquals("¹¹", compositeUnit.buildPower(11));
	}
}