package pcb.uwu.unit.base;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;

import java.util.function.Function;

public abstract class TimeUnit extends BaseUnit {

	private final UnitCounter unitCounter;

	public TimeUnit(String symbol, String singularName, String pluralName,
			Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
			Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(3, symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);

		unitCounter = new UnitCounter(this);
	}

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return TimeUnit.class;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return unitCounter;
	}
}
