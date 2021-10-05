package pcb.uwu.amount.derived.mechanics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.KiloGrams
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.thermodynamics.Pascals
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.SecondUnit
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.mechanics.AccelerationUnit

class NewtonsTest
{
    @Test
    fun dividedByAcceleration() =
        assertEquals("4 Kg",
                     Newtons(12).div(Acceleration(amount = 3, unit = AccelerationUnit(MeterUnit, SecondUnit))).toString())

    @Test
    fun dividedByMass() =
        assertEquals("3 m⋅s⁻²",
                     Newtons(12).div(KiloGrams(4)).toString())

    @Test
    fun multipliedByLength() =
        assertEquals("60 J",
                     Newtons(12).times(Meters(5)).toString())

    @Test
    fun dividedByPressure() =
        assertEquals("4 m²",
                     Newtons(12).div(Pascals(3)).toString())

    @Test
    fun dividedByArea() =
        assertEquals("3 Pa",
                     Newtons(12).div(Area(amount = 4, unit = SquareMeterUnit)).toString())
}