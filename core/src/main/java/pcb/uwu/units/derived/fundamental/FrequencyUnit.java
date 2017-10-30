package pcb.uwu.units.derived.fundamental;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.TimeUnit;

public class FrequencyUnit extends CompositeUnit {

	public FrequencyUnit(TimeUnit time) {
		super(new UnitCounter()
				.minor(time));
	}
}
