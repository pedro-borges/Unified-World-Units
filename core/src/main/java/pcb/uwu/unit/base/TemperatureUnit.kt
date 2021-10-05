package pcb.uwu.unit.base;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;

import java.util.function.Function;

public class TemperatureUnit extends BaseUnit {

	private final UnitCounter unitCounter;

	public TemperatureUnit(String symbol, String singularName, String pluralName,
			Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
			Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(5, symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);

		unitCounter = new UnitCounter(this);
	}

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return TemperatureUnit.class;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return unitCounter;
	}
}
