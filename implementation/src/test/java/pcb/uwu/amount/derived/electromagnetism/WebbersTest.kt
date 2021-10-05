package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.geometry.Area
import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.core.Magnitude.KILO
import pcb.uwu.core.Magnitude.MILLI
import pcb.uwu.unit.derived.geometry.SquareMeterUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class WebbersTest
{
    @Test
    fun dividedByTime() =
        assertEquals(expected = Volts(2),
                     actual = Webbers(12) / Seconds(6))

    @Test
    fun dividedByElectricPotential() =
        assertEquals(expected = Seconds(6),
                     actual = Webbers(12) / Volts(2))

    @Test
    fun dividedByElectricCurrent() =
        assertEquals(expected = Henries(2000),
                     actual = Webbers(12) / Amperes(6, MILLI))

    @Test
    fun dividedByElectricInductance() =
        assertEquals(expected = Amperes(0.006),
                     actual = Webbers(12) / Henries(2, KILO))

    @Test
    fun dividedByMagneticField() =
        assertEquals(expected = SquareMeters(2),
                     actual = Webbers(12) / Teslas(6))

    @Test
    fun dividedByArea() =
        assertEquals(expected = Teslas(6),
                     actual = Webbers(12) / Area(amount = 2, unit = SquareMeterUnit))

    @Test
    fun multiplyByElectricCurrent() =
        assertEquals(expected = Joules(0.6),
                     actual = Webbers(12) * Amperes(50, MILLI))

}