package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.Objects;
import java.util.function.Function;

public class BaseUnit<U extends Unit>
		implements Unit {

	// region private fields

	private final String symbol;
	private final String singularName;
	private final String pluralName;
	private final Function<Amount, Amount> translationToCanonical;
	private final Function<Amount, Amount> translationFromCanonical;

	// endregion

	// region constructors

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

	// endregion

	// region implement Unit

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
	public Function<Amount, Amount> getTranslationToCanonical() {
		return translationToCanonical;
	}

	@Override
	public Function<Amount, Amount> getTranslationFromCanonical() {
		return translationFromCanonical;
	}

	// endregion

	// region overload Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Unit) {
			BaseUnit<?> other = (BaseUnit<?>) obj;

			return Objects.equals(this.symbol, other.symbol) &&
					Objects.equals(this.singularName, other.singularName) &&
					Objects.equals(this.pluralName, other.pluralName) &&
					Objects.equals(this.translationToCanonical, other.translationToCanonical) &&
					Objects.equals(this.translationFromCanonical, other.translationFromCanonical);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}

	// endregion
}
