package pcb.uwu.core

import pcb.uwu.core.Amount.Companion.ONE
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.unit.base.ScalarUnit
import pcb.uwu.util.hash

abstract class BaseUnit(private val precedence: Int,
                        override val symbol: String,
                        override val singularName: String,
                        override val pluralName: String,
                        override val translationToCanonical: (Amount) -> Amount,
                        override val translationFromCanonical: (Amount) -> Amount,
                        val magnitude: Magnitude = NATURAL)
    : Unit,
      Comparable<BaseUnit>
{
    /**
     * {@inheritDoc}
     */
    override val isScalar: Boolean
        get() = this is ScalarUnit

    // region Comparable

    override fun compareTo(other: BaseUnit): Int
    {
        return this.precedence - other.precedence
    }

    //endregion

    // region Object

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is Unit) return false
        return symbol == other.symbol &&
                singularName == other.singularName &&
                pluralName == other.pluralName &&
                toCanonical(ONE) == other.toCanonical(ONE) &&
                fromCanonical(ONE) == other.fromCanonical(ONE)
    }

    override fun hashCode(): Int
    {
        return hash(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical)
    }
}