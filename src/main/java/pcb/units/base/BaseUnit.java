package pcb.units.base;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.Function;

public class BaseUnit<U extends Unit>
		implements Unit {

	// region private fields

	private final String symbol;
	private final String singularName;
	private final String pluralName;
	private final Function<BigDecimal, BigDecimal> translationToCanonical;
	private final Function<BigDecimal, BigDecimal> translationFromCanonical;

	// endregion

	// region constructors

	public BaseUnit(
			String symbol,
			String singularName,
			String pluralName,
			Function<BigDecimal, BigDecimal> translationToCanonical,
			Function<BigDecimal, BigDecimal> translationFromCanonical) {

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
	public Function<BigDecimal, BigDecimal> getTranslationToCanonical() {
		return translationToCanonical;
	}

	@Override
	public Function<BigDecimal, BigDecimal> getTranslationFromCanonical() {
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
