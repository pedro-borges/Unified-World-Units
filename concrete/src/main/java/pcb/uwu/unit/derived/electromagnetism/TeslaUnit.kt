package pcb.uwu.unit.derived.electromagnetism;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

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
