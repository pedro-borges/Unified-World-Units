package pcb.uwu.units.composite.termodynamics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit;
import pcb.uwu.units.composite.electromagnetism.ElectricPotentialUnit;
import pcb.uwu.units.composite.fundamental.VolumeUnit;
import pcb.uwu.units.composite.mechanics.ForceUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class EnergyUnit extends CompositeUnit {

	// region base constructor

	public EnergyUnit(LengthUnit lengthUnit, MassUnit massUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(timeUnit, 2));
	}

	// endregion

	// region composite constructors

	public EnergyUnit(ForceUnit forceUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.major(lengthUnit));
	}

	public EnergyUnit(PressureUnit pressureUnit, VolumeUnit volumeUnit) {
		super(new UnitCounter()
				.major(pressureUnit.getUnitCounter())
				.major(volumeUnit.getUnitCounter()));
	}

	public EnergyUnit(PowerUnit powerUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(powerUnit.getUnitCounter())
				.major(timeUnit));
	}

	public EnergyUnit(ElectricChargeUnit electricChargeUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(electricChargeUnit.getUnitCounter())
				.major(electricPotentialUnit.getUnitCounter()));
	}

	// endregion

}
