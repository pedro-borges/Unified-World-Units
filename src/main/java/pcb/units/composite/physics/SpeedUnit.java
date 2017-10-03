package pcb.units.composite.physics;

import pcb.units.base.ComposedUnit;
import pcb.units.base.Unit;
import pcb.units.dimensions.space.SpaceUnit;
import pcb.units.dimensions.time.TimeUnit;
import pcb.units.utils.ObjectCounter;

public class SpeedUnit
		extends ComposedUnit
		implements Unit {

	public SpeedUnit(SpaceUnit spaceUnit, TimeUnit timeUnit) {
		super(new ObjectCounter<Unit>()
				.major(spaceUnit)
				.minor(timeUnit));
	}
}
