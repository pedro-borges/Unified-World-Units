package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.ElectricResistanceUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class OhmUnit extends ElectricResistanceUnit {

	public static final OhmUnit OHM = new OhmUnit();

	public OhmUnit() {
		super(KILOGRAM, METER, AMPERE, SECOND);
	}
}
