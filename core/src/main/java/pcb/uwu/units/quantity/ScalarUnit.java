package pcb.uwu.units.quantity;

import pcb.uwu.core.BaseUnit;

import java.util.function.Function;

public class ScalarUnit extends BaseUnit {

	public static final ScalarUnit SCALAR = new ScalarUnit();

	private ScalarUnit() {
		super("", "", "", Function.identity(), Function.identity());
	}
}
