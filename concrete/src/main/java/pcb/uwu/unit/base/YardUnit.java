package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class YardUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_YARD = new BigDecimal("0.9144");

	public static final YardUnit YARD = new YardUnit();

	private YardUnit() {
		super("yd", "yard", "yards",
				value -> value.times(METERS_PER_YARD, DECIMAL64),
				value -> value.div(METERS_PER_YARD, DECIMAL64));
	}
}
