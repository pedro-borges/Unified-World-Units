package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class InchUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	public static final InchUnit INCH = new InchUnit();

	private InchUnit() {
		super("in", "inch", "inches",
				value -> value.multipliedBy(METERS_PER_INCH, DECIMAL64),
				value -> value.dividedBy(METERS_PER_INCH, DECIMAL64));
	}
}
