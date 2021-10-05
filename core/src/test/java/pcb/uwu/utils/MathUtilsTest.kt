package pcb.uwu.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import pcb.uwu.utils.MathUtils.min

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