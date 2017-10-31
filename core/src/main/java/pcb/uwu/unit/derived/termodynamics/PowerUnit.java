package pcb.uwu.unit.derived.termodynamics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;

public class PowerUnit extends CompositeUnit {

	// region base constructor

	public PowerUnit(LengthUnit lengthUnit, MassUnit massUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(timeUnit, 3));
	}

	// endregion

	// region derived constructors

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
