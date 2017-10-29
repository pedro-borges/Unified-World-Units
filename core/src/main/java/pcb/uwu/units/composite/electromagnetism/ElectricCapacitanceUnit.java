package pcb.uwu.units.composite.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.composite.mechanics.ForceUnit;
import pcb.uwu.units.quantity.ElectricCurrentUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class ElectricCapacitanceUnit extends CompositeUnit {

	// region base constructor

	public ElectricCapacitanceUnit(ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit, LengthUnit lengthUnit, MassUnit massUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit, 2)
				.major(timeUnit, 4)
				.minor(lengthUnit, 2)
				.minor(massUnit));
	}

	// endregion

	// region composite constructors

	public ElectricCapacitanceUnit(ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit)
				.major(timeUnit)
				.minor(electricPotentialUnit.getUnitCounter()));
	}

	public ElectricCapacitanceUnit(ForceUnit forceUnit, LengthUnit lengthUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.major(lengthUnit)
				.minor(electricPotentialUnit.getUnitCounter()));
	}

	public ElectricCapacitanceUnit(ElectricChargeUnit electricChargeUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(electricChargeUnit.getUnitCounter())
				.minor(electricPotentialUnit.getUnitCounter()));
	}

	public ElectricCapacitanceUnit(TimeUnit timeUnit, ElectricResistanceUnit electricResistanceUnit) {
		super(new UnitCounter()
				.major(timeUnit)
				.minor(electricResistanceUnit.getUnitCounter()));
	}

	// endregion
}
