package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;

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
