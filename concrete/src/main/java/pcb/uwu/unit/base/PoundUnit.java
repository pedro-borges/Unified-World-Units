package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class PoundUnit extends MassUnit {

	private static final BigDecimal KILOGRAMS_PER_POUND = new BigDecimal("0.45359237");

	public static final PoundUnit POUND = new PoundUnit();

	private PoundUnit() {
		super("lb", "pound", "pounds",
				value -> value.multipliedBy(KILOGRAMS_PER_POUND, DECIMAL64),
				value -> value.dividedBy(KILOGRAMS_PER_POUND, DECIMAL64));
	}
}
