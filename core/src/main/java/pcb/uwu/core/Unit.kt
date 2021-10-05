package pcb.uwu.core

import java.util.function.Function

/**
 * Represents a unit, either basic or complex.
 */
interface Unit
{
    /**
     * @return the international symbol representation of this Unit
     */
    val symbol: String

    /**
     * @return the international singular name of this Unit
     */
    val singularName: String

    /**
     * @return the international plural name of this Unit
     */
    val pluralName: String

    /**
     * @return a scalar function that converts this unit to the respective canonical
     */
    val translationToCanonical: Function<Amount, Amount>

    fun toCanonical(amount: Amount) = translationToCanonical.apply(amount)

    /**
     * @return a scalar function that converts this unit from the respective canonical
     */
    val translationFromCanonical: Function<Amount, Amount>

    fun fromCanonical(amount: Amount) = translationFromCanonical.apply(amount)

    /**
     * Assert if the unit is a scalar.
     * @return true if this unit is a scalar, false otherwise
     */
    val isScalar: Boolean
    val baseUnitType: Class<out BaseUnit>
    val unitCounter: UnitCounter
}