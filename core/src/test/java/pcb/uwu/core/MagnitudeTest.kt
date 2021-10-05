package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.core.Magnitude.*
import java.math.BigDecimal

class MagnitudeTest
{
    @Test
    fun testValues()
    {
        assertEquals(BigDecimal("1000000000000"), TERA.amount)
        assertEquals(BigDecimal("1000000000"), GIGA.amount)
        assertEquals(BigDecimal("1000000"), MEGA.amount)
        assertEquals(BigDecimal("1000"), KILO.amount)
        assertEquals(BigDecimal("100"), HECTA.amount)
        assertEquals(BigDecimal("10"), DEKA.amount)
        assertEquals(BigDecimal("1"), NATURAL.amount)
        assertEquals(BigDecimal("0.1"), DECI.amount)
        assertEquals(BigDecimal("0.01"), CENTI.amount)
        assertEquals(BigDecimal("0.001"), MILLI.amount)
        assertEquals(BigDecimal("0.000001"), MICRO.amount)
        assertEquals(BigDecimal("0.000000001"), NANO.amount)
        assertEquals(BigDecimal("0.000000000001"), PICO.amount)
    }
}