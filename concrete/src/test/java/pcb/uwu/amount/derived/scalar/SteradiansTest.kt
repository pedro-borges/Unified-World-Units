package pcb.uwu.amount.derived.scalar

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Candelas
import pcb.uwu.amount.derived.optics.Lumens
import java.math.MathContext.DECIMAL64

class SteradiansTest
{
    @Test
    fun multipliedByLuminousIntensity() =
        assertEquals(Lumens(39),
                     Steradians(13).multipliedBy(Candelas(3), DECIMAL64))

}