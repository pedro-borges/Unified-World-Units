package pcb.uwu.core

import pcb.uwu.amount.base.Amperes
import pcb.uwu.amount.base.Meters
import kotlin.test.Test
import kotlin.test.assertEquals

class UnitAmountTest
{
    @Test
    fun testMajorMajor() =
        assertEquals(expected = "100 m⋅A²",
                     actual = (Meters(1) * Amperes(10) * Amperes(10)).toString())

    @Test
    fun testMinorMajor() =
        assertEquals(expected = "1 m",
                     actual = (Meters(1) / Amperes(10) * Amperes(10)).toString())


    @Test
    fun testMajorMinor() =
        assertEquals(expected = "1 m",
                     actual = (Meters(1) * Amperes(10) / Amperes(10)).toString())
}