package pcb.uwu.unit.base

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import pcb.uwu.amount.base.*
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.UnitAmount
import java.math.MathContext.DECIMAL64
import java.math.RoundingMode.HALF_EVEN

@RunWith(Parameterized::class)
class TimeUnitTest(private val time: Time)
{
    @Test
    fun testConversions()
    {
        for (unitAmount in testData())
        {
            assertEquals(BigDecimalAmount.ONE.withScale(6, HALF_EVEN),
                         time.dividedBy(unitAmount, DECIMAL64).amount.withScale(6, HALF_EVEN))
        }
    }

    companion object
    {
        @JvmStatic
        @Parameters
        fun testData(): Array<UnitAmount<TimeUnit>>
        {
            return arrayOf(seconds, minutes, hours, days, weeks)
        }

        private val seconds = Seconds(604800)
        private val minutes = Minutes(10080)
        private val hours = Hours(168)
        private val days = Days(7)
        private val weeks = Weeks(1)
    }
}