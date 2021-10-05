package pcb.uwu.unit.derived.optics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LuminousIntensityUnit;
import pcb.uwu.unit.derived.scalar.SolidAngleUnit;

public class LuminousFluxUnit extends CompositeUnit {

	// region base constructor

	public LuminousFluxUnit(LuminousIntensityUnit luminousIntensityUnit, SolidAngleUnit solidAngleUnit) {
		super(new UnitCounter()
				.major(luminousIntensityUnit.getUnitCounter())
				.major(solidAngleUnit));
	}

	// endregion

}
