package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.MassUnit;

import java.util.function.Function;

public class GramUnit
		extends BaseUnit<MassUnit>
		implements MassUnit {

	public GramUnit() {
		super("g", "gram", "grams",
				Function.identity(),
				Function.identity());
	}
}
