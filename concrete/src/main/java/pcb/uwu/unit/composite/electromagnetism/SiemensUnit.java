package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.ElectricConductanceUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class SiemensUnit extends ElectricConductanceUnit {

	public static final SiemensUnit SIEMENS = new SiemensUnit();

	public SiemensUnit() {
		super(KILOGRAM, METER, AMPERE, SECOND);
	}

	@Override
	public String getSymbol() {
		return "S";
	}

	@Override
	public String getSingularName() {
		return "siemens";
	}

	@Override
	public String getPluralName() {
		return "siemens";
	}
}
