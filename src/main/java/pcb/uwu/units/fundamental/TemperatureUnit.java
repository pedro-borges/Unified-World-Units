package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;

import java.util.function.Function;

public class TemperatureUnit extends BaseUnit<TemperatureUnit> {

	public static final TemperatureUnit KELVIN = new TemperatureUnit(
			"K", "kelvin", "kelvins",
			Function.identity(),
			Function.identity());

	private TemperatureUnit(String symbol,
							String singularName,
							String pluralName,
							Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
							Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
