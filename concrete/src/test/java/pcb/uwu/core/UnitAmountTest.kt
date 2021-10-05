package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Yards
import java.math.MathContext.DECIMAL64

class UnitAmountTest
{
    @Test
    fun testMajorMajor()
    {
        assertEquals("13.37803776 m³",
                     Meters(1).times(Yards(4).multipliedBy(Yards(4), DECIMAL64), DECIMAL64).toString())
        assertEquals("0.06835083114610674 yd⁻¹",
                     Meters(1).div(Yards(4).multipliedBy(Yards(4), DECIMAL64), DECIMAL64).toString())
    }

    @Test
    fun testMajorMinor() =
        assertEquals("0.06835083114610674 yd⁻¹",
                     Meters(1).times(Yards(4).multipliedBy(Yards(4), DECIMAL64).invert(DECIMAL64), DECIMAL64)
                         .toString())
}