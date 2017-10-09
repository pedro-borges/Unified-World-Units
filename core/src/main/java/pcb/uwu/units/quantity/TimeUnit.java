package pcb.uwu.units.quantity;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;

import java.util.function.Function;

public abstract class TimeUnit extends BaseUnit {

	public TimeUnit(String symbol,
					 String singularName,
					 String pluralName,
					 Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
					 Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
