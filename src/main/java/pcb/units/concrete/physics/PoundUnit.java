package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.MassUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class PoundUnit
		extends BaseUnit<MassUnit>
		implements MassUnit {

	public static final PoundUnit instance = new PoundUnit();

	private static final BigDecimal GRAMS_PER_POUND = new BigDecimal("453.59237");

	private PoundUnit() {
		super("lb", "pound", "pounds",
				value -> value.multiply(GRAMS_PER_POUND, DECIMAL64),
				value -> value.divide(GRAMS_PER_POUND, DECIMAL64)
		);
	}
}
