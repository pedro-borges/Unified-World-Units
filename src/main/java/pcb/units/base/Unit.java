package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.MathContext;
import java.util.function.Function;

public interface Unit<T extends Unit<T>> {
	String getSymbol();
	String getSingularName();
	String getPluralName();
}
