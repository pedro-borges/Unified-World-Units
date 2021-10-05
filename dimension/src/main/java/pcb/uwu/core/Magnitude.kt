package pcb.uwu.core

import java.math.BigDecimal

enum class Magnitude(order: Int, val symbol: String)
{
    PICO(-12, "p"),
    NANO(-9, "n"),
    MICRO(-6, "μ"),
    MILLI(-3, "m"),
    CENTI(-2, "c"),
    DECI(-1, "d"),
    NATURAL(0, ""),
    DEKA(1, "D"),
    HECTA(2, "H"),
    KILO(3, "K"),
    MEGA(6, "M"),
    GIGA(9, "G"),
    TERA(12, "T");

    val amount: BigDecimal

    fun symbol(): String
    {
        return symbol
    }

    fun translationFrom() =
        { amount: Amount -> amount / this.amount }

    fun translationTo() =
        { amount: Amount -> amount * this.amount }

    companion object
    {
        val ALL_MAGNITUDES = listOf(PICO, NANO, MICRO, MILLI, CENTI, DECI, NATURAL, DEKA, HECTA, KILO, MEGA, GIGA, TERA)
        val MAJOR_MAGNITUDES = listOf(PICO, NANO, MICRO, MILLI, NATURAL, KILO, MEGA, GIGA, TERA)
    }

    init
    {
        amount = BigDecimal.ONE.movePointRight(order)
    }
}