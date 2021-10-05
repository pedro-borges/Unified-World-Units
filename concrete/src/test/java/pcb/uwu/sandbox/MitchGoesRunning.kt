package pcb.uwu.sandbox

import org.junit.Assert
import org.junit.Test
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.MileUnit
import pcb.uwu.unit.base.MinuteUnit
import pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit

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
        Assert.assertEquals("2.777777777777777777777777777777778 m⋅s⁻¹", (mitchSpeed to MeterPerSecondUnit).toString())
        Assert.assertEquals("2.4384 m⋅s⁻¹", (wifeSpeed to MeterPerSecondUnit).toString())
    }
}