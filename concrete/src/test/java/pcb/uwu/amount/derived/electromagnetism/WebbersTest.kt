package pcb.uwu.amount.derived.electromagnetism

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MILLI
import pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER

class WebbersTest
{
    @Test
    fun dividedByTime() =
        assertEquals("2 V",
                     Webbers(12).div(Seconds(6)).toString())

    @Test
    fun dividedByElectricPotential() =
        assertEquals("6 s",
                     Webbers(12).div(Volts(2)).toString())

    @Test
    fun dividedByElectricCurrent() =
        assertEquals("2000 H",
                     Webbers(12).div(Amperes(6, MILLI)).toString())

    @Test
    fun dividedByElectricInductance() =
        assertEquals("0.006 A",
                     Webbers(12).div(Henries(2, KILO)).toString())

    @Test
    fun dividedByMagneticField() =
        assertEquals("2 m²",
                     Webbers(12).div(Teslas(6)).toString())

    @Test
    fun dividedByArea() =
        assertEquals("6 T",
                     Webbers(12).div(Area(amount = 2, unit = SQUARE_METER)).toString())

    @Test
    fun multiplyByElectricCurrent() =
        assertEquals("0.6 J",
                     Webbers(12).times(Amperes(50, MILLI)).toString())

}