package pcb.uwu.unit.derived.optics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.LuminousIntensityUnit;
import pcb.uwu.unit.derived.area.AreaUnit;
import pcb.uwu.unit.derived.scalar.SolidAngleUnit;

public class IlluminanceUnit extends CompositeUnit {

	// region base constructor

	public IlluminanceUnit(LuminousIntensityUnit luminousIntensityUnit, SolidAngleUnit solidAngleUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(luminousIntensityUnit.getUnitCounter())
				.major(solidAngleUnit)
				.minor(lengthUnit, 2));
	}

	public IlluminanceUnit(LuminousFluxUnit luminousFluxUnit, AreaUnit areaUnit) {
		super(new UnitCounter()
				.major(luminousFluxUnit.getUnitCounter())
				.minor(areaUnit.getUnitCounter()));
	}

	// endregion

}
