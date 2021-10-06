package pcb.uwu.util

import java.math.BigDecimal

object MathUtils
{
    @JvmField
    val PI = BigDecimal(Math.PI)

    @SafeVarargs
    fun <T : Comparable<T>> max(vararg element: T) =
        element.maxOrNull()

    @SafeVarargs
    fun <T : Comparable<T>> min(vararg element: T) =
        element.minOrNull()
}
