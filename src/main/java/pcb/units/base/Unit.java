package pcb.units.base;

import java.math.BigDecimal;
import java.util.function.Function;

public interface Unit {
	String getSymbol();
	String getSingularName();
	String getPluralName();
	Function<BigDecimal, BigDecimal> getTranslationToCanonical();
	Function<BigDecimal, BigDecimal> getTranslationFromCanonical();
}
