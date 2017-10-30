package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.units.derived.electromagnetism.ElectricResistanceUnit;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class OhmUnit extends ElectricResistanceUnit {

	public static final OhmUnit OHM = new OhmUnit();

	public OhmUnit() {
		super(KILOGRAM, METER, AMPERE, SECOND);
	}

	@Override
	public String getSymbol() {
		return "Ω";
	}

	@Override
	public String getSingularName() {
		return "ohm";
	}

	@Override
	public String getPluralName() {
		return "ohms";
	}
}
