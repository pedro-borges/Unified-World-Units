package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.termodynamics.EnergyUnit;

public class MagneticFluxUnit extends CompositeUnit {

	// region base constructor

	public MagneticFluxUnit(MassUnit massUnit, LengthUnit lengthUnit, ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(electricCurrentUnit)
				.minor(timeUnit, 2));
	}

	// endregion

	// region derived constructors

	public MagneticFluxUnit(ElectricPotentialUnit electricPotentialUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(electricPotentialUnit.getUnitCounter())
				.major(timeUnit));
	}

	public MagneticFluxUnit(ElectricInductanceUnit electricInductanceUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(electricInductanceUnit.getUnitCounter())
				.major(electricCurrentUnit.getUnitCounter()));
	}

	public MagneticFluxUnit(MagneticFieldUnit magneticFieldUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(magneticFieldUnit.getUnitCounter())
				.major(lengthUnit, 2));
	}

	public MagneticFluxUnit(EnergyUnit energyUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(energyUnit.getUnitCounter())
				.minor(electricCurrentUnit.getUnitCounter()));
	}

	// endregion


}
