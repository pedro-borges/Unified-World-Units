package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.function.Function;

public interface Unit {
	String getSymbol();
	String getSingularName();
	String getPluralName();
	Function<Amount, Amount> getTranslationToCanonical();
	Function<Amount, Amount> getTranslationFromCanonical();
}
