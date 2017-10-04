package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.MassUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class OunceUnit
		extends BaseUnit<MassUnit>
		implements MassUnit {

	public static final OunceUnit instance = new OunceUnit();

	private static final BigDecimal GRAMS_PER_OUNCE = new BigDecimal("28.349523125");

	private OunceUnit() {
		super("oz", "ounce", "ounces",
				value -> value.multiply(GRAMS_PER_OUNCE, DECIMAL64),
				value -> value.divide(GRAMS_PER_OUNCE, DECIMAL64)
		);
	}
}
