package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;

public class ElectricConductanceUnit extends CompositeUnit {

	// region base constructor

	public ElectricConductanceUnit(MassUnit massUnit, LengthUnit lengthUnit, ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(timeUnit, 3)
				.major(electricCurrentUnit, 2)
				.minor(massUnit)
				.minor(lengthUnit, 2));
	}

	// endregion

	// region derived constructors

	public ElectricConductanceUnit(ElectricResistanceUnit electricResistanceUnit) {
		super(new UnitCounter()
				.minor(electricResistanceUnit.getUnitCounter()));
	}

	// endregion

}
