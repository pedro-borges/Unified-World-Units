package pcb.uwu.core

interface UnitAmount<U : Unit> : Comparable<UnitAmount<U>>
{
    val amount: Amount

    val unit: U

    operator fun plus(amount: UnitAmount<U>): UnitAmount<U>

    operator fun minus(amount: UnitAmount<U>): UnitAmount<U>

    operator fun times(amount: UnitAmount<out Unit>): UnitAmount<Unit>

    operator fun div(amount: UnitAmount<out Unit>): UnitAmount<Unit>

    operator fun times(scalar: Number): UnitAmount<U>

    operator fun div(scalar: Number): UnitAmount<U>

    fun invert(): UnitAmount<out Unit>

    infix fun to(unit: U): UnitAmount<U>

    fun isEquivalentTo(unitAmount: UnitAmount<*>): Boolean
}