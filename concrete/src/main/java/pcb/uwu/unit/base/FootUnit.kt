package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class FootUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_FOOT = new BigDecimal("0.3048");

	public static final FootUnit FOOT = new FootUnit();

	private FootUnit() {
		super("ft", "foot", "feet",
				value -> value.times(METERS_PER_FOOT),
				value -> value.div(METERS_PER_FOOT));
	}
}
