package pcb.uwu.units.composite.fundamental;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.TimeUnit;

public class FrequencyUnit extends CompositeUnit {

	public FrequencyUnit(TimeUnit time) {
		super(new UnitCounter()
				.minor(time));
	}
}
