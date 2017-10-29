package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.MagneticFieldUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class TeslaUnit extends MagneticFieldUnit {

	public static final TeslaUnit TESLA = new TeslaUnit();

	public TeslaUnit() {
		super(KILOGRAM, AMPERE, SECOND);
	}

	@Override
	public String getSymbol() {
		return "T";
	}

	@Override
	public String getSingularName() {
		return "tesla";
	}

	@Override
	public String getPluralName() {
		return "teslas";
	}
}
