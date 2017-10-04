package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.MassUnit;

import java.util.function.Function;

public class GramUnit
		extends BaseUnit<MassUnit>
		implements MassUnit {

	public static final GramUnit instance = new GramUnit();

	private GramUnit() {
		super("g", "gram", "grams",
				Function.identity(),
				Function.identity());
	}
}
