package pcb.uwu.core

interface UnitAmount<U : Unit> : Comparable<UnitAmount<U>>
{
    val amount: BigDecimalAmount

    val unit: U

    operator fun plus(other: UnitAmount<U>): UnitAmount<U>

    operator fun minus(other: UnitAmount<U>): UnitAmount<U>

    operator fun times(other: UnitAmount<out Unit>): UnitAmount<out Unit>

    operator fun div(other: UnitAmount<out Unit>): UnitAmount<out Unit>

    operator fun times(other: Number): UnitAmount<U>

    operator fun div(other: Number): UnitAmount<U>

    fun invert(): UnitAmount<out Unit>

    fun into(unit: U): UnitAmount<U>

    fun isEquivalentTo(unitAmount: UnitAmount<*>): Boolean
}