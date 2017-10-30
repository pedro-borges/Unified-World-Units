package pcb.uwu.units.derived.optics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.LuminousIntensityUnit;
import pcb.uwu.units.derived.scalar.SolidAngleUnit;

public class LuminousFluxUnit extends CompositeUnit {

	// region base constructor

	public LuminousFluxUnit(LuminousIntensityUnit luminousIntensityUnit, SolidAngleUnit solidAngleUnit) {
		super(new UnitCounter()
				.major(luminousIntensityUnit.getUnitCounter())
				.major(solidAngleUnit));
	}

	// endregion

}
