package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.ElectricPotentialUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class VoltUnit extends ElectricPotentialUnit {

	public static final VoltUnit VOLT = new VoltUnit();

	public VoltUnit() {
		super(KILOGRAM, METER, AMPERE, SECOND);
	}
}
