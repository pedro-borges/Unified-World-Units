package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.ElectricCurrentUnit;

import java.util.function.Function;

public class AmpereUnit
		extends BaseUnit<ElectricCurrentUnit>
		implements ElectricCurrentUnit {

	public static final AmpereUnit instance = new AmpereUnit();

	private AmpereUnit() {
		super("A", "ampere", "amperes",
				Function.identity(),
				Function.identity());
	}
}