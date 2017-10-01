package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.function.Function;

public interface Unit<N extends Number, T extends Unit<N, T>> {
	String getSymbol();
	String getSingularName();
	String getPluralName();
	Function<Amount<N>, Amount<N>> translationToCanonical();
	Function<Amount<N>, Amount<N>> translationFromCanonical();
}
