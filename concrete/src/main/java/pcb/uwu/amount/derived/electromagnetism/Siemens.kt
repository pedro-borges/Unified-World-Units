package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.ElectricCurrent
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.base.AmpereUnit
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit
import pcb.uwu.unit.derived.electromagnetism.SiemensUnit

class Siemens : ElectricConductance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, SiemensUnit)

    @JvmOverloads
    constructor(value: String,
                magnitude: Magnitude = NATURAL)
            : super(value, magnitude, SiemensUnit)

    // region UnitAmount

    override fun plus(electricConductance: UnitAmount<ElectricConductanceUnit>) =
        Siemens(this.amount + (electricConductance to SiemensUnit).amount)

    override fun minus(electricConductance: UnitAmount<ElectricConductanceUnit>) =
        Siemens(this.amount - (electricConductance to SiemensUnit).amount)

    override fun times(scalar: Number) =
        Siemens(this.amount * scalar)

    override fun div(scalar: Number) =
        Siemens(this.amount / scalar)

    override fun invert() =
        Ohms(amount.invert())

    // endregion

    // region composition

    override fun times(electricCurrent: ElectricCurrent) =
        Volts(this.amount * (electricCurrent to AmpereUnit).amount)

    // endregion
}