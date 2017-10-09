package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.ElectricCurrentUnit;

import java.util.function.Function;

public class AmpereUnit extends ElectricCurrentUnit {

	public static final AmpereUnit AMPERE = new AmpereUnit();

	private AmpereUnit() {
		super("A", "ampere", "amperes",
				Function.identity(),
				Function.identity());
	}
}
