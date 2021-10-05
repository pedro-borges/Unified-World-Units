package pcb.uwu.utils

import java.math.BigDecimal

object MathUtils
{
    @JvmField
	val PI = BigDecimal(Math.PI)

    @SafeVarargs
    fun <T : Comparable<T>> max(first: T, vararg others: T) =
        others.maxOrNull() ?: first

    @SafeVarargs
    fun <T : Comparable<T>> min(first: T, vararg others: T) =
        others.minOrNull() ?: first
}