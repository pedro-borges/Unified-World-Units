package pcb.uwu.sandbox

import org.junit.Assert
import org.junit.Test
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.unit.base.MileUnit
import pcb.uwu.unit.base.MinuteUnit.MINUTE
import pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit

class MitchGoesRunning
{
    @Test
    fun testMitchGoesRunning()
    {
        val mitchDistance = Length(amount = 1000, unit = METER)
        val mitchTime = Time(amount = 6, unit = MINUTE)
        val mitchSpeed = mitchDistance.div(mitchTime)
        val wifeDistance = Length(amount = 1, unit = MileUnit.MILE)
        val wifeTime = Time(amount = 11, unit = MINUTE)
        val wifeSpeed = wifeDistance.div(wifeTime)
        Assert.assertEquals("2.777777777777777777777777777777778 s⁻¹⋅m", mitchSpeed.into(MeterPerSecondUnit.METER_PER_SECOND).toString())
        Assert.assertEquals("2.4384 s⁻¹⋅m", wifeSpeed.into(MeterPerSecondUnit.METER_PER_SECOND).toString())
    }
}