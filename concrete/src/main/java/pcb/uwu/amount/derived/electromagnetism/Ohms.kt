package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit.AMPERE
import pcb.uwu.unit.derived.electromagnetism.ElectricResistanceUnit
import pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM

class Ohms : ElectricResistance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, OHM)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, OHM)

    // region UnitAmount

    override fun plus(electricResistance: UnitAmount<ElectricResistanceUnit>) =
        Ohms(this.amount + (electricResistance to OHM).amount)

    override fun minus(electricResistance: UnitAmount<ElectricResistanceUnit>) =
        Ohms(this.amount - (electricResistance to OHM).amount)

    override fun times(scalar: Number) =
        Ohms(this.amount * scalar)

    override fun div(scalar: Number) =
        Ohms(this.amount / scalar)

    override fun invert() =
        Siemens(amount.invert())

    // endregion

    // region composition

    override fun times(electricCurrent: ElectricCurrent) =
        Volts(this.amount * (electricCurrent to AMPERE).amount)

    // endregion
}