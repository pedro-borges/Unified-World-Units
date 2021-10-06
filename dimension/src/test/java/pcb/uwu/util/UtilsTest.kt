package pcb.uwu.util

import kotlin.test.Test
import kotlin.test.assertEquals

class UtilsTest
{
    val add1 = { string: String -> string + "1" }
    val add2 = { string: String -> string + "2" }

    @Test
    fun testButBefore() =
        assertEquals("21", add1.butBefore(add2)(""))

    @Test
    fun testAndThen() =
        assertEquals("12", add1.andThen(add2)(""))
}
