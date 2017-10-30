package pcb.uwu.units.derived.optics;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.base.LengthUnit;
import pcb.uwu.units.base.LuminousIntensityUnit;
import pcb.uwu.units.derived.fundamental.AreaUnit;
import pcb.uwu.units.derived.scalar.SolidAngleUnit;

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
