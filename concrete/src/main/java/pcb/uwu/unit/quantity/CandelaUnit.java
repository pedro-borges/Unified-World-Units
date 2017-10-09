package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.LuminousIntensityUnit;

import java.util.function.Function;

public class CandelaUnit extends LuminousIntensityUnit {

	public static final CandelaUnit CANDELA = new CandelaUnit();

	private CandelaUnit() {
		super("cd", "candela", "candelas",
				Function.identity(),
				Function.identity());
	}
}
