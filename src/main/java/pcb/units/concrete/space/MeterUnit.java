package pcb.units.concrete.space;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.space.SpaceUnit;

import java.util.function.Function;

public class MeterUnit
		extends BaseUnit<SpaceUnit>
		implements SpaceUnit {

	public MeterUnit() {
		super("m", "meter", "meters",
				Function.identity(),
				Function.identity());
	}
}
