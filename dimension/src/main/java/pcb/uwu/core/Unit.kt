package pcb.uwu.core

import kotlin.reflect.KClass

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
     * @return a function that converts this unit to the respective canonical
     */
    val translationToCanonical: (Amount) -> Amount

    fun toCanonical(amount: Amount) =
        translationToCanonical.invoke(amount)

    /**
     * @return a function that converts this unit from the respective canonical
     */
    val translationFromCanonical: (Amount) -> Amount

    fun fromCanonical(amount: Amount) =
        translationFromCanonical.invoke(amount)

    /**
     * Assert if the unit is a scalar.
     * @return true if this unit is a scalar, false otherwise
     */
    val isScalar: Boolean
    val baseUnitType: KClass<out BaseUnit>
    val unitCounter: UnitCounter
}
