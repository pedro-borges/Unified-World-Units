package pcb.uwu.unit.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.units.quantity.TemperatureUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;
import static java.math.MathContext.UNLIMITED;

public class FahrenheitUnit extends TemperatureUnit {

	public static final FahrenheitUnit FAHRENHEIT = new FahrenheitUnit();

	public FahrenheitUnit() {
		super("°F", "fahrenheit", "fahrenheit",
				value -> value
						.plus(new BigDecimalAmount("459.67")
						.multipliedBy(new BigDecimal(5), UNLIMITED)
						.dividedBy(new BigDecimal(9), DECIMAL64), UNLIMITED),
				value -> value
						.multipliedBy(new BigDecimal(9), UNLIMITED)
						.dividedBy(new BigDecimal(5), DECIMAL64)
						.minus(new BigDecimalAmount("459.67"), UNLIMITED));
	}
}
