package pcb.uwu.unit.derived.termodynamics;

import pcb.uwu.units.derived.termodynamics.EnergyUnit;

import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class JouleUnit extends EnergyUnit {

	public static final JouleUnit JOULE = new JouleUnit();

	public JouleUnit() {
		super(METER, KILOGRAM, SECOND);
	}

	@Override
	public String getSymbol() {
		return "J";
	}

	@Override
	public String getSingularName() {
		return "joule";
	}

	@Override
	public String getPluralName() {
		return "joules";
	}
}
