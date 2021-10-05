package pcb.uwu.unit.derived.electromagnetism;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class WebberUnit extends MagneticFluxUnit {

	public static final WebberUnit WEBBER = new WebberUnit();

	public WebberUnit() {
		super(KILOGRAM, METER, AMPERE, SECOND);
	}

	@Override
	public String getSymbol() {
		return "Wb";
	}

	@Override
	public String getSingularName() {
		return "webber";
	}

	@Override
	public String getPluralName() {
		return "webbers";
	}
}
