package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.ElectricCapacitanceUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class FaradUnit extends ElectricCapacitanceUnit {

	public static final FaradUnit FARAD = new FaradUnit();

	public FaradUnit() {
		super(AMPERE, SECOND, METER, KILOGRAM);
	}

	@Override
	public String getSymbol() {
		return "F";
	}

	@Override
	public String getSingularName() {
		return "farad";
	}

	@Override
	public String getPluralName() {
		return "farads";
	}
}
