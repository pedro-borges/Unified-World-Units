package pcb.units.concrete.si;

import pcb.units.amount.Amount;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.util.function.Function;

public class MeterUnit<N extends Number> implements SpaceUnit<N> {
	@Override
	public String getSymbol() {
		return "m";
	}

	@Override
	public String getSingularName() {
		return "meter";
	}

	@Override
	public String getPluralName() {
		return "meters";
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
