package pcb.uwu.unit.composite.termodynamics;

import pcb.uwu.units.composite.termodynamics.PressureUnit;

import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

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
