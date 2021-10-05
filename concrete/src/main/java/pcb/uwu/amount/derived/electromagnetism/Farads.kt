package pcb.uwu.amount.derived.electromagnetism

import pcb.uwu.amount.base.Seconds
import pcb.uwu.core.Magnitude
import pcb.uwu.core.Magnitude.NATURAL
import pcb.uwu.core.UnitAmount
import pcb.uwu.unit.derived.electromagnetism.ElectricCapacitanceUnit
import pcb.uwu.unit.derived.electromagnetism.FaradUnit.FARAD
import pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM
import pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT

class Farads : ElectricCapacitance
{
    @JvmOverloads
    constructor(amount: Number,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FARAD)

    @JvmOverloads
    constructor(amount: String,
                magnitude: Magnitude = NATURAL)
            : super(amount, magnitude, FARAD)

    // region UnitAmount

    override fun plus(electricCapacitance: UnitAmount<ElectricCapacitanceUnit>) =
        Farads(this.amount + (electricCapacitance to FARAD).amount)

    override fun minus(electricCapacitance: UnitAmount<ElectricCapacitanceUnit>) =
        Farads(this.amount - (electricCapacitance to FARAD).amount)

    override fun times(scalar: Number) =
        Farads(this.amount * scalar)

    override fun div(scalar: Number) =
        Farads(this.amount / scalar)

    // endregion

    // region composition

    operator fun times(electricPotential: ElectricPotential) =
        Coulombs(this.amount * (electricPotential to VOLT).amount)

    operator fun times(electricResistance: ElectricResistance) =
        Seconds(this.amount * (electricResistance to OHM).amount)

    // endregion
}