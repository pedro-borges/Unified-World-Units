package pcb.uwu.amount.base

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.derived.fundamental.area.SquareMeters
import pcb.uwu.amount.derived.optics.Nits
import pcb.uwu.amount.derived.scalar.Steradians
import java.math.MathContext.DECIMAL64

class CandelasTest
{
    @Test
    fun multipliedBySolidAngle() =
        assertEquals("54 lm",
                     Candelas(18).multipliedBy(Steradians(3), DECIMAL64).toString())

    @Test
    fun dividedByArea() =
        assertEquals("6 nit",
                     Candelas(18).dividedBy(SquareMeters(3), DECIMAL64).toString())

    @Test
    fun dividedByLuminance() =
        assertEquals("3 m²",
                     Candelas(18).dividedBy(Nits(6), DECIMAL64).toString())
}