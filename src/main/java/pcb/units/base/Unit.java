package pcb.units.base;

import java.util.function.Function;

public interface Unit<N extends Number, T extends Unit<N, T>> {
	String getSymbol();
	String getSingularName();
	String getPluralName();
	Function<N, N> translationToCanonical();
	Function<N, N> translationFromCanonical();
}
