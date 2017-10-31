package pcb.uwu.unit.derived.optics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LuminousIntensityUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.scalar.SolidAngleUnit;

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
