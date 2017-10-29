package pcb.uwu.unit.composite.termodynamics;

import pcb.uwu.units.composite.termodynamics.PowerUnit;

import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class WattUnit extends PowerUnit {

	public static final WattUnit WATT = new WattUnit();

	public WattUnit() {
		super(METER, KILOGRAM, SECOND);
	}

	@Override
	public String getSymbol() {
		return "W";
	}

	@Override
	public String getSingularName() {
		return "watt";
	}

	@Override
	public String getPluralName() {
		return "watts";
	}
}
