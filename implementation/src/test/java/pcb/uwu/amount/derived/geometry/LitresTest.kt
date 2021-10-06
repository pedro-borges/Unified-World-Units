package pcb.uwu.amount.derived.geometry

import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.geometry.volume.CubicMeters
import pcb.uwu.amount.derived.geometry.volume.Litres
import pcb.uwu.core.Magnitude.CENTI
import pcb.uwu.core.Magnitude.DECI
import pcb.uwu.core.Magnitude.MILLI
import pcb.uwu.unit.derived.geometry.CubicMeterUnit
import pcb.uwu.unit.derived.geometry.LitreUnit
import kotlin.test.Test
import kotlin.test.assertEquals

class LitresTest
{
    @Test
    fun construct()
    {
        assertEquals(CubicMeters(0.001),
                     Litres(1) to CubicMeterUnit)
        assertEquals(Litres(3030),
                     Volume(amount = "3.03", unit = CubicMeterUnit) to LitreUnit)
    }

    @Test
    fun sphereFactory()
    {
        assertEquals(Litres("0.004188790204786390821330617958058913"),
                     Litres.FOR.sphere(Meters(10, MILLI)))
        assertEquals(Litres("4.188790204786390821330617958058913"),
                     Litres.FOR.sphere(Meters(10, CENTI)))
        assertEquals(Litres("4188.790204786390821330617958058913"),
                     Litres.FOR.sphere(Meters(10, DECI)))
    }

    @Test
    fun cubeFactory()
    {
        assertEquals(Litres(0.001),
                     Litres.FOR.cube(Meters(1, CENTI)))
        assertEquals(Litres(1),
                     Litres.FOR.cube(Meters(1, DECI)))
        assertEquals(Litres(1000),
                     Litres.FOR.cube(Meters(1)))
    }
}
