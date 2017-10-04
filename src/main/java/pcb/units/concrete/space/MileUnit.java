package pcb.units.concrete.space;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class MileUnit
		extends BaseUnit<SpaceUnit>
		implements SpaceUnit {

	public static final MileUnit instance = new MileUnit();

	private static final BigDecimal METERS_PER_MILE = new BigDecimal("1609.344");

	private MileUnit() {
		super("mile", "mile", "miles",
				value -> value.multiply(METERS_PER_MILE, DECIMAL64),
				value -> value.divide(METERS_PER_MILE, DECIMAL64)
		);
	}
}
