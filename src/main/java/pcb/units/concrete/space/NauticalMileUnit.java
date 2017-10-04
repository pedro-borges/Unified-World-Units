package pcb.units.concrete.space;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class NauticalMileUnit
		extends BaseUnit<SpaceUnit>
		implements SpaceUnit {

	public static final NauticalMileUnit instance = new NauticalMileUnit();

	private static final BigDecimal METERS_PER_NAUTICAL_MILE = new BigDecimal("1852");

	private NauticalMileUnit() {
		super("mile", "mile", "miles",
				value -> value.multiply(METERS_PER_NAUTICAL_MILE, DECIMAL64),
				value -> value.divide(METERS_PER_NAUTICAL_MILE, DECIMAL64)
		);
	}
}
