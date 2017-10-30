package pcb.uwu.unit.base;

import pcb.uwu.units.base.TemperatureUnit;

import java.util.function.Function;

public class KelvinUnit extends TemperatureUnit {

	public static final KelvinUnit KELVIN = new KelvinUnit();

	private KelvinUnit() {
		super("K", "kelvin", "kelvins",
				Function.identity(),
				Function.identity());
	}
}
