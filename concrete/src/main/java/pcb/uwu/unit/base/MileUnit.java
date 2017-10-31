package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class MileUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_MILE = new BigDecimal("1609.344");

	public static final MileUnit MILE = new MileUnit();

	private MileUnit() {
		super("mile", "mile", "miles",
				value -> value.multipliedBy(METERS_PER_MILE, DECIMAL64),
				value -> value.dividedBy(METERS_PER_MILE, DECIMAL64));
	}
}
