package pcb.uwu.amount.derived.fudamental

import org.junit.Assert.assertEquals
import org.junit.Test
import pcb.uwu.amount.base.Meters
import pcb.uwu.amount.derived.fundamental.Volume
import pcb.uwu.amount.derived.fundamental.volume.Litres
import pcb.uwu.core.Magnitude.*
import pcb.uwu.unit.base.MeterUnit.METER
import pcb.uwu.unit.derived.fundamental.LitreUnit.LITRE
import pcb.uwu.unit.derived.fundamental.VolumeUnit

class LitresTest
{
    @Test
    fun construct()
    {
        assertEquals("1 l",
                     Litres(1).toString())
        assertEquals("0.001 m³",
                     Litres(1).into(VolumeUnit(METER, METER, METER)).toString())
        assertEquals("3030 l",
                     Volume(amount = "3.03", unit = VolumeUnit(METER, METER, METER)).into(LITRE).toString())
    }

    @Test
    fun sphereFactory()
    {
        assertEquals("0.004188790204786390821330617958058913 l",
                     Litres.FOR.sphere(Meters(10, MILLI)).toString())
        assertEquals("4.188790204786390821330617958058913 l",
                     Litres.FOR.sphere(Meters(10, CENTI)).toString())
        assertEquals("4188.790204786390821330617958058913 l",
                     Litres.FOR.sphere(Meters(10, DECI)).toString())
    }

    @Test
    fun cubeFactory()
    {
        assertEquals("0.001 l",
                     Litres.FOR.cube(Meters(1, CENTI)).toString())
        assertEquals("1 l",
                     Litres.FOR.cube(Meters(1, DECI)).toString())
        assertEquals("1000 l",
                     Litres.FOR.cube(Meters(1)).toString())
    }
}