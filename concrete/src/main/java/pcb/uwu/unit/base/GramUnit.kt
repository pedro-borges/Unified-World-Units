package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class GramUnit extends MassUnit {

	private static final BigDecimal GRAMS_PER_KILOGRAM = new BigDecimal(1_000);

	public static final GramUnit GRAM = new GramUnit();

	private GramUnit() {
		super("g", "gram", "grams",
				amount -> amount.div(GRAMS_PER_KILOGRAM),
				amount -> amount.times(GRAMS_PER_KILOGRAM));
	}
}
