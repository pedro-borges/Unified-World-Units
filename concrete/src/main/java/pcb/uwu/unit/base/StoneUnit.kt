package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class StoneUnit extends MassUnit {

	private static final BigDecimal KILOGRAMS_PER_STONE = new BigDecimal("6.35029318");

	public static final StoneUnit STONE = new StoneUnit();

	private StoneUnit() {
		super("st", "stone", "stones",
				value -> value.times(KILOGRAMS_PER_STONE),
				value -> value.div(KILOGRAMS_PER_STONE));
	}
}
