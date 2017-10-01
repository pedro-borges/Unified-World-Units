package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.function.Function;

public class BaseUnit<U extends Unit>
		implements Unit {

	private final String symbol;
	private final String singularName;
	private final String pluralName;
	private final Function<Amount, Amount> translationToCanonical;
	private final Function<Amount, Amount> translationFromCanonical;

	public BaseUnit(
			String symbol,
			String singularName,
			String pluralName,
			Function<Amount, Amount> translationToCanonical,
			Function<Amount, Amount> translationFromCanonical) {

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
	public Function<Amount, Amount> translationToCanonical() {
		return translationToCanonical;
	}

	@Override
	public Function<Amount, Amount> translationFromCanonical() {
		return translationFromCanonical;
	}
}
