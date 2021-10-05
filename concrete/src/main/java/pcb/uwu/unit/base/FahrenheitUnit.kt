package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class FahrenheitUnit extends TemperatureUnit {

	public static final FahrenheitUnit FAHRENHEIT = new FahrenheitUnit();

	public FahrenheitUnit() {
		super("°F", "fahrenheit", "fahrenheit",
				value -> value
						.plus(new BigDecimal("459.67"))
						.times(new BigDecimal(5))
						.div(new BigDecimal(9)),
				value -> value
						.times(new BigDecimal(9))
						.div(new BigDecimal(5))
						.minus(new BigDecimal("459.67")));
	}
}
