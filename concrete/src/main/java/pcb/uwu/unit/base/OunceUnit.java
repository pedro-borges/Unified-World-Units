package pcb.uwu.unit.base;

import pcb.uwu.units.base.MassUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class OunceUnit extends MassUnit {

	private static final BigDecimal KILOGRAMS_PER_OUNCE = new BigDecimal("28.349523125");

	public static final OunceUnit OUNCE = new OunceUnit();

	private OunceUnit() {
		super("oz", "ounce", "ounces",
				value -> value.multipliedBy(KILOGRAMS_PER_OUNCE, DECIMAL64),
				value -> value.dividedBy(KILOGRAMS_PER_OUNCE, DECIMAL64));
	}
}
