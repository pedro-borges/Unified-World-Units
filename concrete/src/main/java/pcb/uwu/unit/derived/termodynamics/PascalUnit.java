package pcb.uwu.unit.derived.termodynamics;

import pcb.uwu.units.derived.termodynamics.PressureUnit;

import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class PascalUnit extends PressureUnit {

	public static final PascalUnit PASCAL = new PascalUnit();

	public PascalUnit() {
		super(METER, KILOGRAM, SECOND);
	}

	@Override
	public String getSymbol() {
		return "Pa";
	}

	@Override
	public String getSingularName() {
		return "pascal";
	}

	@Override
	public String getPluralName() {
		return "pascals";
	}
}
