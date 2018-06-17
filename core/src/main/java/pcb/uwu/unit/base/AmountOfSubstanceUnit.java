package pcb.uwu.unit.base;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;

import java.util.function.Function;

public class AmountOfSubstanceUnit extends BaseUnit {
	private final UnitCounter unitCounter;

	public AmountOfSubstanceUnit(String symbol, String singularName, String pluralName,
					  Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
					  Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(1, symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);

		unitCounter = new UnitCounter(this);
	}

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return AmountOfSubstanceUnit.class;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return unitCounter;
	}
}
