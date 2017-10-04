package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;

import java.math.BigDecimal;
import java.util.function.Function;

public class TemperatureUnit extends BaseUnit<TemperatureUnit> {

	public static final TemperatureUnit KELVIN = new TemperatureUnit(
			"K", "kelvin", "kelvins",
			Function.identity(),
			Function.identity());

	private TemperatureUnit(String symbol, String singularName, String pluralName, Function<BigDecimal, BigDecimal> translationToCanonical, Function<BigDecimal, BigDecimal> translationFromCanonical) {
		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
