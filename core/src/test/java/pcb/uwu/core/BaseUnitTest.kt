package pcb.uwu.core

import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.MassUnit
import pcb.uwu.util.identity
import kotlin.test.Test
import kotlin.test.assertEquals


class BaseUnitTest
{
    private val length: LengthUnit = LengthUnit("", "", "", identity(), identity())
    private val mass: MassUnit = MassUnit("", "", "", identity(), identity())

    @Test
    fun testPrecedence() =
        assertEquals(listOf(length, mass), listOf(mass, length).sorted())
}