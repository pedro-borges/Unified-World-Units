package pcb.uwu.sandbox

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Hours
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.finance.Currency
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.unit.finance.CurrencyUnit.Companion.GBP

class RunningCostTest
{
    @Test
    fun test()
    {
        val duration = Meters(70, KILO) / (Meters(13, KILO) / Hours(1))
        val cost = Currency(18, GBP) / Hours(1)
        assertEquals("96.92 £", (cost * duration).toString())
    }
}