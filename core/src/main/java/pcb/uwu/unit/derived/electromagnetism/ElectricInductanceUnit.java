package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.termodynamics.EnergyUnit;

public class ElectricInductanceUnit extends CompositeUnit {

	// region base constructor

	public ElectricInductanceUnit(MassUnit massUnit, LengthUnit lengthUnit, ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(electricCurrentUnit, 2)
				.minor(timeUnit, 2));
	}

	// endregion

	// region derived constructors

	public ElectricInductanceUnit(MassUnit massUnit, LengthUnit lengthUnit, ElectricChargeUnit electricChargeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(electricChargeUnit.getUnitCounter()));
	}

	public ElectricInductanceUnit(EnergyUnit energyUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(energyUnit.getUnitCounter())
				.minor(electricCurrentUnit, 2));
	}

	public ElectricInductanceUnit(MagneticFieldUnit magneticFieldUnit, LengthUnit lengthUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(magneticFieldUnit.getUnitCounter())
				.major(lengthUnit, 2)
				.minor(electricCurrentUnit));
	}

	public ElectricInductanceUnit(MagneticFluxUnit magneticFluxUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(magneticFluxUnit.getUnitCounter())
				.minor(electricCurrentUnit));
	}

	public ElectricInductanceUnit(ElectricPotentialUnit electricPotentialUnit, TimeUnit timeUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit.getUnitCounter())
				.major(timeUnit)
				.minor(electricCurrentUnit));
	}

	public ElectricInductanceUnit(TimeUnit timeUnit, ElectricCapacitanceUnit electricCapacitanceUnit) {
		super(new UnitCounter()
				.major(timeUnit, 2)
				.minor(electricCapacitanceUnit.getUnitCounter()));
	}

	public ElectricInductanceUnit(ElectricResistanceUnit electricResistanceUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(electricResistanceUnit.getUnitCounter())
				.major(timeUnit));
	}

	// endregion

}
