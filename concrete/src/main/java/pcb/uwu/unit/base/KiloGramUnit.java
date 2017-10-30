package pcb.uwu.unit.base;

import pcb.uwu.units.base.MassUnit;

import java.util.function.Function;

public class KiloGramUnit extends MassUnit {

	public static final KiloGramUnit KILOGRAM = new KiloGramUnit();

	private KiloGramUnit() {
		super("Kg", "kilogram", "kilograms",
				Function.identity(),
				Function.identity());
	}
}
