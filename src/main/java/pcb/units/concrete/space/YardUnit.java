package pcb.units.concrete.space;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class YardUnit
		extends BaseUnit<SpaceUnit>
		implements SpaceUnit {

	public static final YardUnit instance = new YardUnit();

	private static final BigDecimal METERS_PER_YARD = new BigDecimal("0.9144");

	private YardUnit() {
		super("yd", "yard", "yards",
				value -> value.multiply(METERS_PER_YARD, DECIMAL64),
				value -> value.divide(METERS_PER_YARD, DECIMAL64)
		);
	}
}
