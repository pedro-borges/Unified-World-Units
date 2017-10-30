package pcb.uwu.unit.derived.termodynamics;

import pcb.uwu.units.derived.termodynamics.PowerUnit;

import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

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
