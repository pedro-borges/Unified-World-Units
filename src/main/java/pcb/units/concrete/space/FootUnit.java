package pcb.units.concrete.space;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class FootUnit
		extends BaseUnit<SpaceUnit>
		implements SpaceUnit {

	public static final FootUnit instance = new FootUnit();

	private static final BigDecimal METERS_PER_FOOT = new BigDecimal("0.3048");

	private FootUnit() {
		super("ft", "foot", "feet",
				value -> value.multiply(METERS_PER_FOOT, DECIMAL64),
				value -> value.divide(METERS_PER_FOOT, DECIMAL64)
		);
	}
}
