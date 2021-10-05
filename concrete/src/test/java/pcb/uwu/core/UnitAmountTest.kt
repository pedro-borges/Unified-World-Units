package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Meters

class UnitAmountTest
{
    @Test
    fun testMajorMajor() =
        assertEquals("100 m⋅A²",
                     Meters(1)
                         .times(Amperes(10))
                         .times(Amperes(10))
                         .toString())

    @Test
    fun testMinorMajor() =
        assertEquals("1 m",
                     Meters(1)
                         .div(Amperes(10))
                         .times(Amperes(10))
                         .toString())


    @Test
    fun testMajorMinor() =
        assertEquals("1 m",
                     Meters(1)
                         .times(Amperes(10))
                         .div(Amperes(10))
                         .toString())
}