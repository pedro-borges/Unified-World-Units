package pcb.uwu.sandbox

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Hours
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.finance.Money
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.unit.finance.CurrencyUnit

class RunningCostTest
{
    @Test
    fun test()
    {
        val duration = Meters(70, KILO).div(Meters(13, KILO).div(Hours(1)))
        val price = Money(18, CurrencyUnit.of("GBP")).div(Hours(1)).times(duration)
        assertEquals("96.92 £", price.toString())
    }
}