package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;

import java.math.BigDecimal;
import java.util.function.Function;

public class ElectricCurrentUnit extends BaseUnit<ElectricCurrentUnit> {

	public static final ElectricCurrentUnit AMPERE = new ElectricCurrentUnit(
			"A", "ampere", "amperes",
			Function.identity(),
			Function.identity());

	private ElectricCurrentUnit(String symbol,
								String singularName,
								String pluralName,
								Function<BigDecimal, BigDecimal> translationToCanonical,
								Function<BigDecimal, BigDecimal> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
