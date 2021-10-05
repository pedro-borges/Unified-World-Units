package pcb.uwu.amount.derived.thermodynamics

import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.fundamental.CubicMeterUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class PascalsTest
{
    @Test
    fun multipliedByVolume() =
        assertEquals("27 J",
                     Pascals(9).times(Volume(amount = 3, unit = CubicMeterUnit)).toString())

    @Test
    fun multipliedByArea() =
        assertEquals("18 N",
                     Pascals(9).times(Area(amount = 2, unit = SquareMeterUnit)).toString())

}