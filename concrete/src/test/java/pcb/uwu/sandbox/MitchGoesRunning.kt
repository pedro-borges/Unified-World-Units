package pcb.uwu.sandbox

import org.junit.Assert
import org.junit.Test
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.unit.base.MeterUnit
import pcb.uwu.unit.base.MileUnit
import pcb.uwu.unit.base.MinuteUnit
import pcb.uwu.unit.derived.mechanics.MeterPerSecondUnit
import java.math.MathContext

class MitchGoesRunning
{
    @Test
    fun testMitchGoesRunning()
    {
        val mitchDistance = Length(1000, MeterUnit.METER)
        val mitchTime = Time(6, MinuteUnit.MINUTE)
        val mitchSpeed = mitchDistance.dividedBy(mitchTime, MathContext.DECIMAL64)
        val wifeDistance = Length(1, MileUnit.MILE)
        val wifeTime = Time(11, MinuteUnit.MINUTE)
        val wifeSpeed = wifeDistance.dividedBy(wifeTime, MathContext.DECIMAL64)
        Assert.assertEquals("2.777777777777778 s⁻¹⋅m", mitchSpeed.`in`(MeterPerSecondUnit.METER_PER_SECOND).toString())
        Assert.assertEquals("2.4384 s⁻¹⋅m", wifeSpeed.`in`(MeterPerSecondUnit.METER_PER_SECOND).toString())
    }
}