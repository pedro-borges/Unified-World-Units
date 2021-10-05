package pcb.uwu.amount.derived.mechanics

import pcb.uwu.amount.base.KiloGrams
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.thermodynamics.Joules
import pcb.uwu.amount.derived.thermodynamics.Pascals
import kotlin.test.Test
import kotlin.test.assertEquals

class NewtonsTest
{
    @Test
    fun dividedByAcceleration() =
        assertEquals(expected = KiloGrams(amount = 4),
                     actual = Newtons(12) / MetersPerSquareSecond(3))

    @Test
    fun dividedByMass() =
        assertEquals(expected = MetersPerSquareSecond(3),
                     actual = Newtons(12) / KiloGrams(4))

    @Test
    fun multipliedByLength() =
        assertEquals(expected = Joules(60),
                     actual = Newtons(12) * Meters(5))

    @Test
    fun dividedByPressure() =
        assertEquals(expected = SquareMeters(4),
                     actual = Newtons(12) / Pascals(3))

    @Test
    fun dividedByArea() =
        assertEquals(expected = Pascals(3),
                     actual = Newtons(12) / SquareMeters(4))
}