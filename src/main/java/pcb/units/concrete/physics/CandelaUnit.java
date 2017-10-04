package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.LuminousIntensityUnit;

import java.util.function.Function;

public class CandelaUnit
		extends BaseUnit<LuminousIntensityUnit>
		implements LuminousIntensityUnit {

	public static final CandelaUnit instance = new CandelaUnit();

	private CandelaUnit() {
		super("cd", "candela", "candelas",
				Function.identity(),
				Function.identity());
	}
}
