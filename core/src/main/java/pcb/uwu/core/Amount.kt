package pcb.uwu.core

import java.math.BigDecimal
import java.math.MathContext.DECIMAL128
import java.math.RoundingMode
import java.util.function.Function

/**
 * An implementation of Amount for uni-dimensional values based on `java.lang.BigDecimal` representation.
 */
class Amount(val value: BigDecimal) : Number(), Comparable<Amount>
{
    constructor(value: Number) : this(BigDecimal(value.toString()))
    constructor(value: String) : this(BigDecimal(value))

    // region public methods

    /**
     * The scale of this `BigDecimalAmount`.
     *
     * @return the scale of the `BigDecimalAmount`
     */
    val scale: Int
        get() = value.scale()

    /**
     * Set the scale of the `BigDecimalAmount`.
     *
     * @param scale        the new scale to set
     * @param roundingMode the rounding mode
     * @return a new Amount with the new scale
     */
    fun withScale(scale: Int, roundingMode: RoundingMode) =
        Amount(value.setScale(scale, roundingMode))

    fun invert() =
        ONE.div(this)

    operator fun unaryMinus() =
        Amount(value.negate())

    /**
     * Sum amount.
     *
     * @param other the `BigDecimalAmount` to add
     * @return a new `BigDecimalAmount` representing this + other
     */
    operator fun plus(other: BigDecimal) =
        Amount(value.add(other))

    operator fun plus(other: Amount) =
        Amount(value.add(other.value))

    operator fun minus(other: BigDecimal) =
        Amount(value.subtract(other))

    operator fun minus(other: Amount) =
        Amount(value.subtract(other.value))

    /**
     * Multiply by a scalar.
     *
     * @param other       the value to multiply by
     * @return a new `BigDecimalAmount` representing this × other
     */
    operator fun times(other: Number) =
        Amount(value.multiply(BigDecimal(other.toString()), DECIMAL128))

    /**
     * Divide by a scalar.
     *
     * @param other       the value to divide by
     * @return a new `BigDecimalAmount` representing this ÷ other
     */
    operator fun div(other: Number) =
        Amount(value.divide(BigDecimal(other.toString()), DECIMAL128))

    /**
     * Elevate to power.
     *
     * @param power       the exponential factor
     * @return a new `BigDecimalAmount` representing `this`ⁿ
     */
    fun pow(power: Int) =
        Amount(value.pow(power, DECIMAL128))

    /**
     * translate with scalar function.
     *
     * @param transformation a function representing a generic transformation from scalar to scalar
     * @return a new `BigDecimalAmount` with the transformed value
     */
    fun transformed(transformation: Function<Amount, Amount>) =
        transformation.apply(this)

    /**
     * Check if this `BigDecimalAmount` is zero.
     *
     * @return true if this `Amount` is zero, false otherwise
     */
    val isZero: Boolean
        get() = compareTo(ZERO) == 0

    /**
     * Check if this `BigDecimalAmount` is positive.
     *
     * @return true if this `BigDecimalAmount` is positive, false otherwise
     */
    val isPositive: Boolean
        get() = compareTo(ZERO) > 0

    /**
     * Check if this `BigDecimalAmount` is negative.
     *
     * @return true if this `BigDecimalAmount` is negative, false otherwise
     */
    val isNegative: Boolean
        get() = compareTo(ZERO) < 0

    /**
     * {@inheritDoc}
     */
    override fun toInt() =
        value.toInt()

    /**
     * {@inheritDoc}
     */
    override fun toLong() =
        value.toLong()

    /**
     * {@inheritDoc}
     */
    override fun toFloat() =
        value.toFloat()

    /**
     * {@inheritDoc}
     */
    override fun toDouble() =
        value.toDouble()

    /**
     * {@inheritDoc}
     */
    override fun toByte() =
        value.toByte()

    /**
     * {@inheritDoc}
     */
    override fun toShort() =
        value.toShort()

    /**
     * {@inheritDoc}
     */
    override fun toChar() =
        value.toChar()

    // endregion

    // region implement Comparable

    override fun compareTo(other: Amount) =
        value.compareTo(other.value)

    // endregion
    // region override Object
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is Amount) return false
        return value == other.value
    }

    override fun hashCode(): Int
    {
        return value.hashCode()
    }

    override fun toString(): String =
        value.stripTrailingZeros().toPlainString()

    // endregion

    companion object
    {
        @JvmField
        val ZERO = Amount(BigDecimal.ZERO)

        @JvmField
        val ONE = Amount(BigDecimal.ONE)
    }
}