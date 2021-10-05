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
import java.math.MathContext.DECIMAL64

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
                     Volume(3.03, VolumeUnit(METER, METER, METER)).into(LITRE).toString())
    }

    @Test
    fun sphereFactory()
    {
        assertEquals("0.00418879020478639 l",
                     Litres.FOR.sphereWithRadius(Meters(10, MILLI), DECIMAL64).toString())
        assertEquals("4.18879020478639 l",
                     Litres.FOR.sphereWithRadius(Meters(10, CENTI), DECIMAL64).toString())
        assertEquals("4188.79020478639 l",
                     Litres.FOR.sphereWithRadius(Meters(10, DECI), DECIMAL64).toString())
    }

    @Test
    fun cubeFactory()
    {
        assertEquals("0.001 l",
                     Litres.FOR.cubeWithSide(Meters(1, CENTI), DECIMAL64).toString())
        assertEquals("1 l",
                     Litres.FOR.cubeWithSide(Meters(1, DECI), DECIMAL64).toString())
        assertEquals("1000 l",
                     Litres.FOR.cubeWithSide(Meters(1), DECIMAL64).toString())
    }
}