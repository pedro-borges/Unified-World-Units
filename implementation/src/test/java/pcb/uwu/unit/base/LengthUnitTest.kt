package pcb.uwu.unit.base

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import pcb.uwu.amount.base.Feet
import pcb.uwu.amount.base.Inches
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.base.Miles
import pcb.uwu.amount.base.Yards
import pcb.uwu.core.Amount
import pcb.uwu.core.UnitAmount
import java.math.RoundingMode.HALF_EVEN
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class LengthUnitTest(private val length: Length)
{
    @Test
    fun testConversions()
    {
        for (unitAmount in testData())
        {
            assertEquals(expected = Amount.ONE.withScale(6, HALF_EVEN),
                         actual = (length / unitAmount).amount.withScale(6, HALF_EVEN))
        }
    }

    companion object
    {
        @JvmStatic
        @Parameters
        fun testData(): Array<UnitAmount<LengthUnit>>
        {
            return arrayOf(miles, yards, meters, feet, inches)
        }

        private val miles = Miles(1)
        private val yards = Yards(1760)
        private val meters = Meters("1609.344")
        private val feet = Feet(5280)
        private val inches = Inches(63360)
    }
}
