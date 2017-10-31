package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;

public class ElectricPotentialUnit extends CompositeUnit {

	// region base Constructor

	public ElectricPotentialUnit(MassUnit massUnit, LengthUnit lengthUnit, ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(electricCurrentUnit)
				.minor(timeUnit, 3));
	}

	// endregion

}
