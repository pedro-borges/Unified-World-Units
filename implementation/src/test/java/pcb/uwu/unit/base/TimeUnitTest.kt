package pcb.uwu.unit.base

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import pcb.uwu.amount.base.Days
import pcb.uwu.amount.base.Hours
import pcb.uwu.amount.base.Minutes
import pcb.uwu.amount.base.Seconds
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.base.Weeks
import pcb.uwu.core.Amount
import pcb.uwu.core.UnitAmount
import java.math.RoundingMode.HALF_EVEN
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class TimeUnitTest(private val time: Time)
{
    @Test
    fun testConversions()
    {
        for (unitAmount in testData())
        {
            assertEquals(expected = Amount.ONE.withScale(6, HALF_EVEN),
                         actual = (time / unitAmount).amount.withScale(6, HALF_EVEN))
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
