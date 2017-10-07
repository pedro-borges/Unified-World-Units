package pcb.uwu.units.composite.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.fundamental.ElectricCurrentUnit;
import pcb.uwu.units.fundamental.TimeUnit;

import static pcb.uwu.units.fundamental.ElectricCurrentUnit.AMPERE;
import static pcb.uwu.units.fundamental.TimeUnit.SECOND;

public class ElectricChargeUnit extends CompositeUnit {

	public static final ElectricChargeUnit COULOMB = new ElectricChargeUnit(AMPERE, SECOND);

	public ElectricChargeUnit(ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit)
				.major(timeUnit));
	}
}
