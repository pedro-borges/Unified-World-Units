package pcb.uwu.unit.derived.mechanics;

import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class NewtonUnit extends ForceUnit {

	public static final NewtonUnit NEWTON = new NewtonUnit();

	public NewtonUnit() {
		super(KILOGRAM, METER, SECOND);
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
