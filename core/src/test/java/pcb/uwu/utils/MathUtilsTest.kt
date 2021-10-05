package pcb.uwu.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class MathUtilsTest
{
    @Test
    fun max()
    {
        assertEquals(5, MathUtils.max(4, 1, 5, 3).toInt().toLong())
        assertEquals(-1, MathUtils.max(-4, -1, -5, -3).toInt().toLong())
    }

    @Test
    fun min()
    {
        assertEquals(1, MathUtils.min(4, 1, 5, 3).toInt())
        assertEquals(-5, MathUtils.min(-4, -1, -5, -3).toInt())
    }
}