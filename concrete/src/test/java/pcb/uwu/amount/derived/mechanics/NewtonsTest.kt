package pcb.uwu.amount.derived.mechanics

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.KiloGrams
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.fundamental.Area
import pcb.uwu.amount.derived.thermodynamics.Pascals
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.unit.base.SecondUnit.SECOND
import pcb.uwu.unit.derived.area.SquareMeterUnit
import pcb.uwu.unit.derived.mechanics.AccelerationUnit
import java.math.MathContext.DECIMAL64

class NewtonsTest
{
    @Test
    fun dividedByAcceleration() =
        assertEquals("4 Kg",
                     Newtons(12).dividedBy(Acceleration(amount = 3, unit = AccelerationUnit(METER, SECOND)), DECIMAL64).toString())

    @Test
    fun dividedByMass() =
        assertEquals("3 s⁻²⋅m",
                     Newtons(12).dividedBy(KiloGrams(4), DECIMAL64).toString())

    @Test
    fun multipliedByLength() =
        assertEquals("60 J",
                     Newtons(12).multipliedBy(Meters(5), DECIMAL64).toString())

    @Test
    fun dividedByPressure() =
        assertEquals("4 m²",
                     Newtons(12).dividedBy(Pascals(3), DECIMAL64).toString())

    @Test
    fun dividedByArea() =
        assertEquals("3 Pa",
                     Newtons(12).dividedBy(Area(4, SquareMeterUnit.SQUARE_METER), DECIMAL64).toString())

}