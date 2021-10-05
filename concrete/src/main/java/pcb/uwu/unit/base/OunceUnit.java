package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class OunceUnit extends MassUnit {

	private static final BigDecimal KILOGRAMS_PER_OUNCE = new BigDecimal("28.349523125");

	public static final OunceUnit OUNCE = new OunceUnit();

	private OunceUnit() {
		super("oz", "ounce", "ounces",
				value -> value.times(KILOGRAMS_PER_OUNCE, DECIMAL64),
				value -> value.div(KILOGRAMS_PER_OUNCE, DECIMAL64));
	}
}
