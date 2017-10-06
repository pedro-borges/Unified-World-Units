package pcb.uwu.core;

import java.util.function.Function;

/**
 * Represents a unit, either basic or complex.
 */
public interface Unit {
	/**
	 * @return the international symbol representation of this Unit
	 */
	String getSymbol();

	/**
	 * @return the international singular name of this Unit
	 */
	String getSingularName();

	/**
	 * @return the international plural name of this Unit
	 */
	String getPluralName();

	/**
	 * @return a scalar function that converts this unit to the respective canonical
	 */
	Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical();

	/**
	 * @return a scalar function that converts this unit from the respective canonical
	 */
	Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical();

	/**
	 * Assert if the unit is a scalar.
	 * @return true if this unit is a scalar, false otherwise
	 */
	boolean isScalar();
}
