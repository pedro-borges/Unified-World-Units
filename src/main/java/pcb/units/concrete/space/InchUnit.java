package pcb.units.concrete.space;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class InchUnit
		extends BaseUnit<SpaceUnit>
		implements SpaceUnit {

	private static final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	public InchUnit() {
		super("in", "inch", "inches",
				value -> value.multiply(METERS_PER_INCH, DECIMAL64),
				value -> value.divide(METERS_PER_INCH, DECIMAL64)
		);
	}
}
