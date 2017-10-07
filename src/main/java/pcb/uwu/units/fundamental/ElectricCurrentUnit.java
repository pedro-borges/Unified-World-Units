package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;

import java.util.function.Function;

public class ElectricCurrentUnit extends BaseUnit {

	public static final ElectricCurrentUnit AMPERE = new ElectricCurrentUnit(
			"A", "ampere", "amperes",
			Function.identity(),
			Function.identity());

	private ElectricCurrentUnit(String symbol,
								String singularName,
								String pluralName,
								Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
								Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
