package pcb.uwu.unit.derived.optics;

import pcb.uwu.units.derived.optics.LuminousFluxUnit;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.derived.scalar.SteradianUnit.STERADIAN;

public class LumenUnit extends LuminousFluxUnit {

	public static final LumenUnit LUMEN = new LumenUnit();

	public LumenUnit() {
		super(CANDELA, STERADIAN);
	}

	@Override
	public String getSymbol() {
		return "lm";
	}

	@Override
	public String getSingularName() {
		return "lumen";
	}

	@Override
	public String getPluralName() {
		return "lumens";
	}
}
