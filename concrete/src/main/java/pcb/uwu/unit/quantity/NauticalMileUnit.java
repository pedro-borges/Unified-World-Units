package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.LengthUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class NauticalMileUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_NAUTICAL_MILE = new BigDecimal("1852");

	public static final NauticalMileUnit NAUTICAL_MILE = new NauticalMileUnit();

	private NauticalMileUnit() {
		super("mile", "mile", "miles",
				value -> value.multipliedBy(METERS_PER_NAUTICAL_MILE, DECIMAL64),
				value -> value.dividedBy(METERS_PER_NAUTICAL_MILE, DECIMAL64));
	}
}
