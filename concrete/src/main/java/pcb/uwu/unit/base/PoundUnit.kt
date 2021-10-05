package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class PoundUnit extends MassUnit {

	private static final BigDecimal KILOGRAMS_PER_POUND = new BigDecimal("0.45359237");

	public static final PoundUnit POUND = new PoundUnit();

	private PoundUnit() {
		super("lb", "pound", "pounds",
				value -> value.times(KILOGRAMS_PER_POUND),
				value -> value.div(KILOGRAMS_PER_POUND));
	}
}
