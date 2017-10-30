package pcb.uwu.units.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.ElectricCurrentUnit;
import pcb.uwu.units.base.TimeUnit;

public class ElectricChargeUnit extends CompositeUnit {

	// region base constructor

	public ElectricChargeUnit(ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit)
				.major(timeUnit));
	}

	// endregion

}
