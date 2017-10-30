package pcb.uwu.units.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.ElectricCurrentUnit;
import pcb.uwu.units.base.LengthUnit;
import pcb.uwu.units.base.MassUnit;
import pcb.uwu.units.base.TimeUnit;

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
