package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Seconds
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricCapacitanceUnit
import pcb.uwu.unit.derived.electromagnetism.FaradUnit
import pcb.uwu.unit.derived.electromagnetism.OhmUnit
import pcb.uwu.unit.derived.electromagnetism.VoltUnit

class Farads : ElectricCapacitance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FaradUnit)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FaradUnit)

    // region UnitAmount

    override fun plus(electricCapacitance: UnitAmount<ElectricCapacitanceUnit>) =
        Farads(this.amount + (electricCapacitance to FaradUnit).amount)

    override fun minus(electricCapacitance: UnitAmount<ElectricCapacitanceUnit>) =
        Farads(this.amount - (electricCapacitance to FaradUnit).amount)

    override fun times(scalar: Number) =
        Farads(this.amount * scalar)

    override fun div(scalar: Number) =
        Farads(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(electricPotential: ElectricPotential) =
        Coulombs(this.amount * (electricPotential to VoltUnit).amount)

    operator fun times(electricResistance: ElectricResistance) =
        Seconds(this.amount * (electricResistance to OhmUnit).amount)

    // endregion
}