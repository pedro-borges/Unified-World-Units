package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.units.derived.electromagnetism.ElectricInductanceUnit;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class HenryUnit extends ElectricInductanceUnit {

	public static final HenryUnit HENRY = new HenryUnit();

	public HenryUnit() {
		super(KILOGRAM, METER, AMPERE, SECOND);
	}

	@Override
	public String getSymbol() {
		return "H";
	}

	@Override
	public String getSingularName() {
		return "henry";
	}

	@Override
	public String getPluralName() {
		return "henrys";
	}
}
