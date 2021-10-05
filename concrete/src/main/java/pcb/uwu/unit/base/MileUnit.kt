package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class MileUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_MILE = new BigDecimal("1609.344");

	public static final MileUnit MILE = new MileUnit();

	private MileUnit() {
		super("mile", "mile", "miles",
				value -> value.times(METERS_PER_MILE),
				value -> value.div(METERS_PER_MILE));
	}
}
