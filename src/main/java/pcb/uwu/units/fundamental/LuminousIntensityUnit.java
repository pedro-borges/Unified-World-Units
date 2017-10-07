package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;

import java.util.function.Function;

public class LuminousIntensityUnit extends BaseUnit {

	public static final LuminousIntensityUnit CANDELA = new LuminousIntensityUnit(
			"cd", "candela", "candelas",
			Function.identity(),
			Function.identity());

	private LuminousIntensityUnit(String symbol,
								  String singularName,
								  String pluralName,
								  Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
								  Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
