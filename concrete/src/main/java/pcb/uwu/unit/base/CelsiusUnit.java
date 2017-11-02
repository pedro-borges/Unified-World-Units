package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class CelsiusUnit extends TemperatureUnit {

	private static final BigDecimal KELVIN_TO_CELSIUS = new BigDecimal("273.15");

	public static final CelsiusUnit CELSIUS = new CelsiusUnit();

	public CelsiusUnit() {
		super("°C", "celsius", "celsius",
				value -> value.minus(KELVIN_TO_CELSIUS),
				value -> value.plus(KELVIN_TO_CELSIUS));
	}
}
