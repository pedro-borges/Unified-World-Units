package pcb.uwu.unit.composite.electromagnetism;

import pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class CoulombUnit extends ElectricChargeUnit {

	public static final CoulombUnit COULOMB = new CoulombUnit();

	public CoulombUnit() {
		super(AMPERE, SECOND);
	}

	@Override
	public String getSymbol() {
		return "C";
	}

	@Override
	public String getSingularName() {
		return "coulomb";
	}

	@Override
	public String getPluralName() {
		return "coulombs";
	}
}
