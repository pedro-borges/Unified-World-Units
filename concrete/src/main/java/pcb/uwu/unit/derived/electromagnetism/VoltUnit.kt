package pcb.uwu.unit.derived.electromagnetism;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class VoltUnit extends ElectricPotentialUnit {

	public static final VoltUnit VOLT = new VoltUnit();

	public VoltUnit() {
		super(KILOGRAM, METER, AMPERE, SECOND);
	}

	@Override
	public String getSymbol() {
		return "V";
	}

	@Override
	public String getSingularName() {
		return "volt";
	}

	@Override
	public String getPluralName() {
		return "volts";
	}
}
