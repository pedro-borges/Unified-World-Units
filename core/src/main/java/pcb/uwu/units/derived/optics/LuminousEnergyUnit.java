package pcb.uwu.units.derived.optics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.LuminousIntensityUnit;
import pcb.uwu.units.base.TimeUnit;
import pcb.uwu.units.derived.scalar.SolidAngleUnit;

public class LuminousEnergyUnit extends CompositeUnit {

	// region base constructor

	public LuminousEnergyUnit(LuminousIntensityUnit luminousIntensityUnit, SolidAngleUnit solidAngleUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(luminousIntensityUnit.getUnitCounter())
				.major(solidAngleUnit)
				.major(timeUnit));
	}

	// endregion

}
