package pcb.units.concrete.fundamental.imperial;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class InchUnit
		extends BaseUnit<SpaceUnit>
		implements SpaceUnit {

	private static final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	public InchUnit() {
		super("in", "inch", "inches",
				value -> value.dividedBy(METERS_PER_INCH, DECIMAL64),
				value -> value.multipliedBy(METERS_PER_INCH, DECIMAL64)
		);
	}
}
