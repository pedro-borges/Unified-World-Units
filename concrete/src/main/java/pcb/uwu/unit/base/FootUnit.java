package pcb.uwu.unit.base;

import pcb.uwu.units.base.LengthUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class FootUnit extends LengthUnit {

	private static final BigDecimal METERS_PER_FOOT = new BigDecimal("0.3048");

	public static final FootUnit FOOT = new FootUnit();

	private FootUnit() {
		super("ft", "foot", "feet",
				value -> value.multipliedBy(METERS_PER_FOOT, DECIMAL64),
				value -> value.dividedBy(METERS_PER_FOOT, DECIMAL64));
	}
}
