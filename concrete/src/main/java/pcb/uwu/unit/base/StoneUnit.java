package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class StoneUnit extends MassUnit {

	private static final BigDecimal KILOGRAMS_PER_STONE = new BigDecimal("6.35029318");

	public static final StoneUnit STONE = new StoneUnit();

	private StoneUnit() {
		super("st", "stone", "stones",
				value -> value.multipliedBy(KILOGRAMS_PER_STONE, DECIMAL64),
				value -> value.dividedBy(KILOGRAMS_PER_STONE, DECIMAL64));
	}
}
