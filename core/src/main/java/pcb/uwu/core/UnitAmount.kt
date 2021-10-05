package pcb.uwu.core

import java.math.BigDecimal
import java.math.MathContext

interface UnitAmount<U : Unit> : Comparable<UnitAmount<U>>
{
    /**
     * @return the underlying `Amount`
     */
    val amount: BigDecimalAmount

    /**
     * @return the underlrying `Unit`
     */
    val unit: U

    /**
     * Sum another `UnitAmount` to this `UnitAmount` using unit conversion when necessary.
     * @param other the `UnitAmount` to add
     * @return a new `AmountUnit` in this `Unit` representing this + other
     */
    operator fun plus(other: UnitAmount<U>): UnitAmount<U>

    /**
     * Subtract another `UnitAmount` from this `UnitAmount` using unit conversion when necessary.
     * @param other the `UnitAmount` to subtract
     * @return a new `AmountUnit` in this `Unit` representing this - other
     */
    fun minus(other: UnitAmount<U>): UnitAmount<U>

    /**
     * Multiply this `UnitAmount` by a scalar value.
     * @param other the scalar value to multiply by
     * @param mathContext the maths context to consider
     * @return a new `AmountUnit` in this `Unit` representing this × other
     */
    fun multiply(other: BigDecimal, mathContext: MathContext): UnitAmount<U>

    /**
     * Divide this `UnitAmount` by a scalar value.
     * @param other the scalar value to divide by
     * @param mathContext the maths context to consider
     * @return a new `AmountUnit` in this `Unit` representing this ÷ other
     */
    fun div(other: BigDecimal, mathContext: MathContext): UnitAmount<U>
    fun multiply(other: UnitAmount<out Unit>, mathContext: MathContext): UnitAmount<out Unit>
    fun div(other: UnitAmount<out Unit>, mathContext: MathContext): UnitAmount<out Unit>
    fun invert(mathContext: MathContext): UnitAmount<out Unit>

    /**
     * Get the `UnitAmount` in a new `Unit`.
     * @param unit the `Unit` to convert to
     * @return the converted `UnitAmount`
     */
    fun into(unit: U): UnitAmount<U>

    /**
     * Compares two `UnitAmount` relaxing to base units
     * i.e. 300 seconds is equivalent to 5 minutes
     * @return true if equivalent, false otherwise
     */
    fun equivalentTo(unitAmount: UnitAmount<*>): Boolean
}