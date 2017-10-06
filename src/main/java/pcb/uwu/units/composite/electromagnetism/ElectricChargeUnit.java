package pcb.uwu.units.composite.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.fundamental.ElectricCurrentUnit;
import pcb.uwu.units.fundamental.TimeUnit;

public class ElectricChargeUnit extends CompositeUnit {

	public ElectricChargeUnit(ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit)
				.major(timeUnit));
	}
}
