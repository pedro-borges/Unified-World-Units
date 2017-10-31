package pcb.uwu.unit.derived.termodynamics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit;
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit;
import pcb.uwu.unit.derived.fundamental.VolumeUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;

public class EnergyUnit extends CompositeUnit {

	// region base constructor

	public EnergyUnit(LengthUnit lengthUnit, MassUnit massUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(timeUnit, 2));
	}

	// endregion

	// region derived constructors

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
