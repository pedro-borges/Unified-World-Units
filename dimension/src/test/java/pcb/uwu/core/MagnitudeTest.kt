package pcb.uwu.core

import pcb.uwu.core.Magnitude.CENTI
import pcb.uwu.core.Magnitude.DECI
import pcb.uwu.core.Magnitude.DEKA
import pcb.uwu.core.Magnitude.GIGA
import pcb.uwu.core.Magnitude.HECTA
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MEGA
import pcb.uwu.core.Magnitude.MICRO
import pcb.uwu.core.Magnitude.MILLI
import pcb.uwu.core.Magnitude.NANO
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.Magnitude.PICO
import pcb.uwu.core.Magnitude.TERA
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

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