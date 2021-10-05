package pcb.uwu.utils

import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest
{
    @Test
    fun testButBefore()
    {
        val add1 = { string: String -> string + "1" }
        val add2 = { string: String -> string + "2" }

        assertEquals("21", add1.butBefore(add2)(""))
    }

    @Test
    fun testAndThen()
    {
        val add1 = { string: String -> string + "1" }
        val add2 = { string: String -> string + "2" }

        assertEquals("12", add1.andThen(add2)(""))
    }
}