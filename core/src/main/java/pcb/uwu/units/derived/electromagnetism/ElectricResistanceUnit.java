package pcb.uwu.units.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.ElectricCurrentUnit;
import pcb.uwu.units.base.LengthUnit;
import pcb.uwu.units.base.MassUnit;
import pcb.uwu.units.base.TimeUnit;

public class ElectricResistanceUnit extends CompositeUnit {

	// region base constructor

	public ElectricResistanceUnit(MassUnit massUnit, LengthUnit lengthUnit, ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(timeUnit, 3)
				.minor(electricCurrentUnit, 2));
	}

	// endregion

	// region derived constructors

	public ElectricResistanceUnit(ElectricConductanceUnit electricConductanceUnit) {
		super(new UnitCounter()
				.minor(electricConductanceUnit.getUnitCounter()));
	}

	// endregion

}
