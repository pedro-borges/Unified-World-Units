package pcb.uwu.amount.derived.optics

import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.derived.geometry.area.SquareMeters
import pcb.uwu.amount.derived.scalar.Steradians
import kotlin.test.Test
import kotlin.test.assertEquals

class LumensTest
{
    @Test
    fun dividedBySolidAngle() =
        assertEquals(expected = Candelas(11),
                     actual = Lumens(22) / Steradians(2))

    @Test
    fun dividedByLuminousIntensity() =
        assertEquals(expected = Steradians(2),
                     actual = Lumens(22) / Candelas(11))

    @Test
    fun dividedByArea() =
        assertEquals(expected = Lux(2),
                     actual = Lumens(22) / SquareMeters(11))

    @Test
    fun dividedByIlluminance() =
        assertEquals(expected = SquareMeters(11),
                     actual = Lumens(22) / Lux(2))

    @Test
    fun multipliedByTime() =
        assertEquals(expected = Talbots(66),
                     actual = Lumens(22) * Seconds(3))
}
