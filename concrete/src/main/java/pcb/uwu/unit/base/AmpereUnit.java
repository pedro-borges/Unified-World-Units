package pcb.uwu.unit.base;

import pcb.uwu.units.base.ElectricCurrentUnit;

import java.util.function.Function;

public class AmpereUnit extends ElectricCurrentUnit {

	public static final AmpereUnit AMPERE = new AmpereUnit();

	private AmpereUnit() {
		super("A", "ampere", "amperes",
				Function.identity(),
				Function.identity());
	}
}
