package pcb.uwu.unit.composite.termodynamics;

import pcb.uwu.units.composite.termodynamics.EnergyUnit;

import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

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
