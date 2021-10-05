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
        assertEquals(BigDecimal("1000000000000"), TERA.value)
        assertEquals(BigDecimal("1000000000"), GIGA.value)
        assertEquals(BigDecimal("1000000"), MEGA.value)
        assertEquals(BigDecimal("1000"), KILO.value)
        assertEquals(BigDecimal("100"), HECTA.value)
        assertEquals(BigDecimal("10"), DEKA.value)
        assertEquals(BigDecimal("1"), NATURAL.value)
        assertEquals(BigDecimal("0.1"), DECI.value)
        assertEquals(BigDecimal("0.01"), CENTI.value)
        assertEquals(BigDecimal("0.001"), MILLI.value)
        assertEquals(BigDecimal("0.000001"), MICRO.value)
        assertEquals(BigDecimal("0.000000001"), NANO.value)
        assertEquals(BigDecimal("0.000000000001"), PICO.value)
    }
}