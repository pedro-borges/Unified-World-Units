package pcb.units.concrete.si;

import pcb.units.amount.Amount;
import pcb.units.dimensions.fundamental.TimeUnit;

import java.util.function.Function;

public class SecondUnit<N extends Number> implements TimeUnit<N> {
	@Override
	public String getSymbol() {
		return "s";
	}

	@Override
	public String getSingularName() {
		return "second";
	}

	@Override
	public String getPluralName() {
		return "seconds";
	}

	@Override
	public Function<Amount<N>, Amount<N>> translationToCanonical() {
		return Function.identity();
	}

	@Override
	public Function<Amount<N>, Amount<N>> translationFromCanonical() {
		return Function.identity();
	}
}
