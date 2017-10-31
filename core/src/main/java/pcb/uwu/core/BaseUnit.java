package pcb.uwu.core;

import pcb.uwu.unit.base.ScalarUnit;

import java.util.Objects;
import java.util.function.Function;

public abstract class BaseUnit implements Unit, Comparable<BaseUnit> {

	// region private fields

	private final int precendence;
	private final String symbol;
	private final String singularName;
	private final String pluralName;
	private final Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical;
	private final Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical;

	// endregion

	// region constructors

	protected BaseUnit(
			int precedence,
			String symbol,
			String singularName,
			String pluralName,
			Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
			Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		this.precendence = precedence;
		this.symbol = symbol;
		this.singularName = singularName;
		this.pluralName = pluralName;
		this.translationToCanonical = translationToCanonical;
		this.translationFromCanonical = translationFromCanonical;
	}

	// endregion

	// region implement Unit

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSymbol() {
		return symbol;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSingularName() {
		return singularName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPluralName() {
		return pluralName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical() {
		return translationToCanonical;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical() {
		return translationFromCanonical;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isScalar() {
		return this instanceof ScalarUnit;
	}

	// endregion

	// region implement Comparable

	@Override
	public int compareTo(BaseUnit other) {
		return other.precendence - this.precendence;
	}

	//endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Unit) {
			BaseUnit other = (BaseUnit) obj;

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

	@Override
	public String toString() {
		return symbol;
	}

	// endregion
}
