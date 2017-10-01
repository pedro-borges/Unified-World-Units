package pcb.units.concrete.fundamental.si;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.fundamental.TimeUnit;

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
