package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class NauticalMileUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_NAUTICAL_MILE = new BigDecimal("1852");

	public static final NauticalMileUnit NAUTICAL_MILE = new NauticalMileUnit();

	private NauticalMileUnit() {
		super("mile", "mile", "miles",
				value -> value.times(METERS_PER_NAUTICAL_MILE),
				value -> value.div(METERS_PER_NAUTICAL_MILE));
	}
}
