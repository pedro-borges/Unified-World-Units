package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;

import java.util.function.Function;

public class ScalarUnit extends BaseUnit<ScalarUnit> {

	private ScalarUnit() {
		super("", "", "", Function.identity(), Function.identity());
	}
}
