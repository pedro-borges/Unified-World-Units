package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;

import java.math.BigDecimal;
import java.util.function.Function;

public class LuminousIntensityUnit extends BaseUnit<LuminousIntensityUnit> {

	public static final LuminousIntensityUnit CANDELA = new LuminousIntensityUnit(
			"cd", "candela", "candelas",
			Function.identity(),
			Function.identity());

	private LuminousIntensityUnit(String symbol,
								  String singularName,
								  String pluralName,
								  Function<BigDecimal, BigDecimal> translationToCanonical,
								  Function<BigDecimal, BigDecimal> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
