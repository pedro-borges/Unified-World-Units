package pcb.uwu.unit.derived.electromagnetism;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

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
