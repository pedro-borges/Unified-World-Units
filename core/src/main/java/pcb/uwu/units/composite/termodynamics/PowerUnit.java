package pcb.uwu.units.composite.termodynamics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.composite.electromagnetism.ElectricPotentialUnit;
import pcb.uwu.units.composite.mechanics.ForceUnit;
import pcb.uwu.units.quantity.ElectricCurrentUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class PowerUnit extends CompositeUnit {

	// region base constructor

	public PowerUnit(LengthUnit lengthUnit, MassUnit massUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(timeUnit, 3));
	}

	// endregion

	// region composite constructors

	public PowerUnit(ForceUnit forceUnit, LengthUnit lengthUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.major(lengthUnit)
				.minor(timeUnit));
	}

	public PowerUnit(EnergyUnit energyUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(energyUnit.getUnitCounter())
				.minor(timeUnit));
	}

	public PowerUnit(PowerUnit powerUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(powerUnit.getUnitCounter())
				.major(timeUnit));
	}

	public PowerUnit(ElectricCurrentUnit electricCurrentUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit.getUnitCounter())
				.major(electricPotentialUnit.getUnitCounter()));
	}

	// endregion

}
