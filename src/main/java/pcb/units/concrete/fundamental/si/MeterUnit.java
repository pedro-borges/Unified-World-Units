package pcb.units.concrete.fundamental.si;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;

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
