package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;
import static java.math.MathContext.UNLIMITED;

public class FahrenheitUnit extends TemperatureUnit {

	public static final FahrenheitUnit FAHRENHEIT = new FahrenheitUnit();

	public FahrenheitUnit() {
		super("°F", "fahrenheit", "fahrenheit",
				value -> value
						.plus(new BigDecimal("459.67"))
						.times(new BigDecimal(5), UNLIMITED)
						.div(new BigDecimal(9), DECIMAL64),
				value -> value
						.times(new BigDecimal(9), UNLIMITED)
						.div(new BigDecimal(5), DECIMAL64)
						.minus(new BigDecimal("459.67")));
	}
}
