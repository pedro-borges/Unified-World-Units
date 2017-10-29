package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.ElectricInductanceUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

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
