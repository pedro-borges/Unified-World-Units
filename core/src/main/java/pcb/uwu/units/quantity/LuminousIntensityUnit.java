package pcb.uwu.units.quantity;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;

import java.util.function.Function;

public abstract class LuminousIntensityUnit extends BaseUnit {

	private final UnitCounter unitCounter;

	public LuminousIntensityUnit(String symbol,
								 String singularName,
								 String pluralName,
								 Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
								 Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(6, symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);

		this.unitCounter = new UnitCounter(this);
	}

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return LuminousIntensityUnit.class;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return unitCounter;
	}
}
