package pcb.uwu.sandbox

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Hours
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.currency.GBP
import pcb.uwu.core.Magnitude.KILO

class RunningCostTest
{
    @Test
    fun test()
    {
        val duration = Meters(70, KILO) / (Meters(13, KILO) / Hours(1))
        val cost = GBP(18) / Hours(1)
        assertEquals("96.92 £", (cost * duration).toString())
    }
}