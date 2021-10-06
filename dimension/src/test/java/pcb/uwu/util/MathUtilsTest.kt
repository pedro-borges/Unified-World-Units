package pcb.uwu.util

import pcb.uwu.util.MathUtils.min
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MathUtilsTest
{
    @Test
    fun max()
    {
        assertEquals(5, MathUtils.max(4, 1, 5, 3)!!.toInt().toLong())
        assertEquals(-1, MathUtils.max(-4, -1, -5, -3)!!.toInt().toLong())
        assertNull(MathUtils.max<Int>())
    }

    @Test
    fun min()
    {
        assertEquals(1, min(4, 1, 5, 3)!!.toInt())
        assertEquals(-5, min(-4, -1, -5, -3)!!.toInt())
        assertNull(min<Int>())
    }
}
