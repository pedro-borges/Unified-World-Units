package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL64;
import static java.math.MathContext.UNLIMITED;

public class TemperatureUnit extends BaseUnit {

	private static final BigDecimalAmount KELVIN_TO_CELSIUS = new BigDecimalAmount("273.15");

	public static final TemperatureUnit KELVIN = new TemperatureUnit(
			"K", "kelvin", "kelvins",
			Function.identity(),
			Function.identity());

	public static final TemperatureUnit CELSIUS = new TemperatureUnit(
			"°C", "celsius", "celsius",
			value -> value.minus(KELVIN_TO_CELSIUS, UNLIMITED),
			value -> value.plus(KELVIN_TO_CELSIUS, UNLIMITED));

	public static final TemperatureUnit FAHRENHEIT = new TemperatureUnit(
			"°F", "fahrenheit", "fahrenheit",
			value -> value
					.plus(new BigDecimalAmount("459.67")
					.multipliedBy(new BigDecimal(5), UNLIMITED)
					.dividedBy(new BigDecimal(9), DECIMAL64),
							UNLIMITED),
			value -> value
					.multipliedBy(new BigDecimal(9), UNLIMITED)
					.dividedBy(new BigDecimal(5), DECIMAL64)
					.minus(new BigDecimalAmount("459.67"),
							UNLIMITED));

	private TemperatureUnit(String symbol,
							String singularName,
							String pluralName,
							Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
							Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
