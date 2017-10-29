package pcb.uwu.units.composite.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.composite.mechanics.ForceUnit;
import pcb.uwu.units.composite.termodynamics.EnergyUnit;
import pcb.uwu.units.quantity.ElectricCurrentUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class MagneticFieldUnit extends CompositeUnit {

	// region base constructor

	public MagneticFieldUnit(MassUnit massUnit, ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.minor(electricCurrentUnit)
				.minor(timeUnit, 2));
	}

	// endregion

	// region composite constructors

	public MagneticFieldUnit(ElectricPotentialUnit electricPotentialUnit, TimeUnit timeUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(electricPotentialUnit.getUnitCounter())
				.major(timeUnit)
				.minor(lengthUnit, 2));
	}

	public MagneticFieldUnit(ForceUnit forceUnit, ElectricCurrentUnit electricCurrentUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.minor(electricCurrentUnit)
				.minor(lengthUnit));
	}

	public MagneticFieldUnit(EnergyUnit energyUnit, ElectricCurrentUnit electricCurrentUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(energyUnit.getUnitCounter())
				.minor(electricCurrentUnit)
				.minor(lengthUnit, 2));
	}

	public MagneticFieldUnit(ElectricInductanceUnit electricInductanceUnit, ElectricCurrentUnit electricCurrentUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(electricInductanceUnit.getUnitCounter())
				.major(electricCurrentUnit)
				.minor(lengthUnit, 2));
	}

	public MagneticFieldUnit(MagneticFluxUnit magneticFluxUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(magneticFluxUnit.getUnitCounter())
				.minor(lengthUnit, 2));
	}

	public MagneticFieldUnit(MassUnit massUnit, ElectricChargeUnit electricChargeUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.minor(electricChargeUnit.getUnitCounter())
				.minor(timeUnit));
	}

	public MagneticFieldUnit(ForceUnit forceUnit, TimeUnit timeUnit, ElectricChargeUnit electricChargeUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.major(timeUnit)
				.minor(electricChargeUnit.getUnitCounter())
				.minor(lengthUnit));
	}

	// endregion


}
