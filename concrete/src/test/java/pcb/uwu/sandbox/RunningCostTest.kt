package pcb.uwu.sandbox

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Hours
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.finance.Money
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.unit.finance.CurrencyUnit
import java.math.MathContext.DECIMAL64
import java.math.MathContext.UNLIMITED

class RunningCostTest
{
    @Test
    fun test()
    {
        val duration = Meters(70, KILO).dividedBy(Meters(13, KILO).dividedBy(Hours(1), UNLIMITED), DECIMAL64)
        val price = Money(18, CurrencyUnit.of("GBP")).dividedBy(Hours(1), UNLIMITED).multipliedBy(duration, UNLIMITED)
        assertEquals("96.92 £", price.toString())
    }
}