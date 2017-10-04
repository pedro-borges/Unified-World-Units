package pcb.units.concrete.physics;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.physics.TemperatureUnit;

import java.util.function.Function;

public class KelvinUnit
		extends BaseUnit<TemperatureUnit>
		implements TemperatureUnit {

	public static final KelvinUnit instance = new KelvinUnit();

	private KelvinUnit() {
		super("K", "kelvin", "kelvins",
				Function.identity(),
				Function.identity());
	}
}
