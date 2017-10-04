package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.MassUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class StoneUnit
		extends BaseUnit<MassUnit>
		implements MassUnit {

	public static final StoneUnit instance = new StoneUnit();

	private static final BigDecimal GRAMS_PER_STONE = new BigDecimal("6350.29318");

	private StoneUnit() {
		super("st", "stone", "stones",
				value -> value.multiply(GRAMS_PER_STONE, DECIMAL64),
				value -> value.divide(GRAMS_PER_STONE, DECIMAL64)
		);
	}
}
