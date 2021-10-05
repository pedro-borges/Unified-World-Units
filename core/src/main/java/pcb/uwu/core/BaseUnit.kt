package pcb.uwu.core

import pcb.uwu.core.BigDecimalAmount.Companion.ONE
import pcb.uwu.unit.base.ScalarUnit
import java.util.Objects
import java.util.function.Function

abstract class BaseUnit(private val precedence: Int,
                        override val symbol: String,
                        override val singularName: String,
                        override val pluralName: String,
                        override val translationToCanonical: Function<BigDecimalAmount, BigDecimalAmount>,
                        override val translationFromCanonical: Function<BigDecimalAmount, BigDecimalAmount>)
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
                translationToCanonical.apply(ONE) == other.translationToCanonical.apply(ONE) &&
                translationFromCanonical.apply(ONE) == other.translationFromCanonical.apply(ONE)
    }

    override fun hashCode(): Int
    {
        return Objects.hash(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical)
    }

    override fun toString(): String
    {
        return symbol
    }
}