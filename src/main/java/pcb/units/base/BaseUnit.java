package pcb.units.base;

import java.util.function.Function;

public class BaseUnit<N extends Number, U extends Unit<N, U>>
		implements Unit<N, U> {

	private final String symbol;
	private final String singularName;
	private final String pluralName;
	private final Function<N, N> translationToCanonical;
	private final Function<N, N> translationFromCanonical;

	public BaseUnit(
			String symbol,
			String singularName,
			String pluralName,
			Function<N, N> translationToCanonical,
			Function<N, N> translationFromCanonical) {

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
	public Function<N, N> translationToCanonical() {
		return translationToCanonical;
	}

	@Override
	public Function<N, N> translationFromCanonical() {
		return translationFromCanonical;
	}
}
