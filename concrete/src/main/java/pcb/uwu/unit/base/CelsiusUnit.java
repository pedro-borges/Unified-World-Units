package pcb.uwu.unit.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.units.base.TemperatureUnit;

import static java.math.MathContext.UNLIMITED;

public class CelsiusUnit extends TemperatureUnit {

	private static final BigDecimalAmount KELVIN_TO_CELSIUS = new BigDecimalAmount("273.15");

	public static final CelsiusUnit CELSIUS = new CelsiusUnit();

	public CelsiusUnit() {
		super("°C", "celsius", "celsius",
				value -> value.minus(KELVIN_TO_CELSIUS, UNLIMITED),
				value -> value.plus(KELVIN_TO_CELSIUS, UNLIMITED));
	}
}
