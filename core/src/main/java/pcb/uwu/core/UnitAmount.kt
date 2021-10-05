package pcb.uwu.core

import pcb.uwu.amount.base.Scalar

interface UnitAmount<U : Unit> : Comparable<UnitAmount<U>>
{
    val amount: Amount

    val unit: U

    operator fun plus(amount: UnitAmount<U>): UnitAmount<U>

    operator fun minus(amount: UnitAmount<U>): UnitAmount<U>

    operator fun times(amount: UnitAmount<out Unit>): UnitAmount<out Unit>

    operator fun div(amount: UnitAmount<out Unit>): UnitAmount<out Unit>

    operator fun times(scalar: Number): UnitAmount<U>

    operator fun div(scalar: Number): UnitAmount<U>

    operator fun div(other: UnitAmount<U>): Scalar

    fun invert(): UnitAmount<out Unit>

    infix fun to(unit: U): UnitAmount<U>

    fun isEquivalentTo(unitAmount: UnitAmount<*>): Boolean
}