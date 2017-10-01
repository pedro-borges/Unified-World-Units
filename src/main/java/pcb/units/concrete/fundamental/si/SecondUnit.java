package pcb.units.concrete.fundamental.si;

import pcb.units.amount.Amount;
import pcb.units.dimensions.fundamental.TimeUnit;

import java.util.function.Function;

public class SecondUnit implements TimeUnit {
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
	public Function<Amount, Amount> getTranslationToCanonical() {
		return Function.identity();
	}

	@Override
	public Function<Amount, Amount> getTranslationFromCanonical() {
		return Function.identity();
	}
}
