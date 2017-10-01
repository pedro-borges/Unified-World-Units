package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.function.Function;

public class BaseUnit<N extends Number, U extends Unit<N, U>>
		implements Unit<N, U> {

	private final String symbol;
	private final String singularName;
	private final String pluralName;
	private final Function<Amount<N>, Amount<N>> translationToCanonical;
	private final Function<Amount<N>, Amount<N>> translationFromCanonical;

	public BaseUnit(
			String symbol,
			String singularName,
			String pluralName,
			Function<Amount<N>, Amount<N>> translationToCanonical,
			Function<Amount<N>, Amount<N>> translationFromCanonical) {

		this.symbol = symbol;
		this.singularName = singularName;
		this.pluralName = pluralName;
		this.translationToCanonical = translationToCanonical;
		this.translationFromCanonical = translationFromCanonical;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public String getSingularName() {
		return singularName;
	}

	@Override
	public String getPluralName() {
		return pluralName;
	}

	@Override
	public Function<Amount<N>, Amount<N>> translationToCanonical() {
		return translationToCanonical;
	}

	@Override
	public Function<Amount<N>, Amount<N>> translationFromCanonical() {
		return translationFromCanonical;
	}
}
