package pcb.uwu.units.quantity;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.UnitCounter;

import java.util.function.Function;

public class ScalarUnit extends BaseUnit {

	public static final ScalarUnit SCALAR = new ScalarUnit();

	private final UnitCounter unitCounter;

	private ScalarUnit() {
		super(0, "", "", "", Function.identity(), Function.identity());

		this.unitCounter = new UnitCounter();
	}

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return null;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return new UnitCounter(); // todo change immutable singleton
	}
}
