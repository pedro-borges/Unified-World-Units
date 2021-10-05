package pcb.uwu.sandbox

import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.amount.derived.mechanics.MetersPerSecond
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.MileUnit
import pcb.uwu.unit.base.MinuteUnit
import pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class MitchGoesRunning
{
    @Test
    fun testMitchGoesRunning()
    {
        val mitchDistance = Length(amount = 1000, unit = MeterUnit)
        val mitchTime = Time(amount = 6, unit = MinuteUnit)
        val mitchSpeed = mitchDistance.div(mitchTime)
        val wifeDistance = Length(amount = 1, unit = MileUnit)
        val wifeTime = Time(amount = 11, unit = MinuteUnit)
        val wifeSpeed = wifeDistance.div(wifeTime)

        assertEquals(expected = MetersPerSecond("2.777777777777777777777777777777778"),
                     actual = mitchSpeed to MeterPerSecondUnit)
        assertEquals(expected = MetersPerSecond(2.4384),
                     actual = (wifeSpeed to MeterPerSecondUnit))
    }
}