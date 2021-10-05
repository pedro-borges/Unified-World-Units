package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class InchUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	public static final InchUnit INCH = new InchUnit();

	private InchUnit() {
		super("in", "inch", "inches",
				value -> value.times(METERS_PER_INCH),
				value -> value.div(METERS_PER_INCH));
	}
}
