package pcb.uwu.unit.composite.mechanics;

import pcb.uwu.units.composite.mechanics.ForceUnit;

import static pcb.uwu.unit.quantity.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class NewtonUnit extends ForceUnit {

	public static final NewtonUnit NEWTON = new NewtonUnit();

	public NewtonUnit() {
		super(KILOGRAM, METER, SECOND, SECOND);
	}

	@Override
	public String getSymbol() {
		return "N";
	}

	@Override
	public String getSingularName() {
		return "newton";
	}

	@Override
	public String getPluralName() {
		return "newtons";
	}
}
