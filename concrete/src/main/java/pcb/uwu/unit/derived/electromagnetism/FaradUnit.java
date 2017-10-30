package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.units.derived.electromagnetism.ElectricCapacitanceUnit;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

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
