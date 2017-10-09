package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.MassUnit;

import java.math.BigDecimal;

import static java.math.MathContext.UNLIMITED;

public class GramUnit extends MassUnit {

	private static final BigDecimal GRAMS_PER_KILOGRAM = new BigDecimal(1_000);

	public static final GramUnit GRAM = new GramUnit();

	private GramUnit() {
		super("g", "gram", "grams",
				amount -> amount.dividedBy(GRAMS_PER_KILOGRAM, UNLIMITED),
				amount -> amount.multipliedBy(GRAMS_PER_KILOGRAM, UNLIMITED));
	}
}
