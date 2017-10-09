package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.TemperatureUnit;

import java.util.function.Function;

public class KelvinUnit extends TemperatureUnit {

	public static final KelvinUnit KELVIN = new KelvinUnit();

	private KelvinUnit() {
		super("K", "kelvin", "kelvins",
				Function.identity(),
				Function.identity());
	}
}
