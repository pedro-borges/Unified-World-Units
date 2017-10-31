package pcb.uwu.unit.derived.fundamental;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.TimeUnit;

public class FrequencyUnit extends CompositeUnit {

	public FrequencyUnit(TimeUnit time) {
		super(new UnitCounter()
				.minor(time));
	}
}
