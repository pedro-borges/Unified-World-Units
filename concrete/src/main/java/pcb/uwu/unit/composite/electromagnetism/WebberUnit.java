package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.MagneticFluxUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

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
