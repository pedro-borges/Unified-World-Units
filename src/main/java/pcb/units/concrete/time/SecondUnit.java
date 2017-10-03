package pcb.units.concrete.time;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.time.TimeUnit;

import java.util.function.Function;

public class SecondUnit
		extends BaseUnit<TimeUnit>
		implements TimeUnit {

	public SecondUnit() {
		super("s", "second", "seconds",
				Function.identity(),
				Function.identity());
	}
}
