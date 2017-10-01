package pcb.units.concrete.fundamental.si;

import pcb.units.amount.Amount;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.util.function.Function;

public class MeterUnit implements SpaceUnit {
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
	public Function<Amount, Amount> translationToCanonical() {
		return Function.identity();
	}

	@Override
	public Function<Amount, Amount> translationFromCanonical() {
		return Function.identity();
	}
}
