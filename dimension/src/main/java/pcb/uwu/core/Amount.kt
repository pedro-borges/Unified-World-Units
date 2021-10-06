package pcb.uwu.core

import java.math.BigDecimal
import java.math.MathContext.DECIMAL128
import java.math.RoundingMode

/**
 * An implementation of Amount for uni-dimensional values based on `java.lang.BigDecimal` representation.
 */
class Amount(val amount: BigDecimal) : Number(), Comparable<Amount>
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
        get() = amount.scale()

    /**
     * Set the scale of the `BigDecimalAmount`.
     *
     * @param scale        the new scale to set
     * @param roundingMode the rounding mode
     * @return a new Amount with the new scale
     */
    fun withScale(scale: Int, roundingMode: RoundingMode) =
        Amount(amount.setScale(scale, roundingMode))

    fun invert() =
        ONE.div(this)

    operator fun unaryMinus() =
        Amount(-amount)

    /**
     * Sum amount.
     *
     * @param other the `BigDecimalAmount` to add
     * @return a new `BigDecimalAmount` representing this + other
     */
    operator fun plus(other: BigDecimal) =
        Amount(this.amount + other)

    operator fun plus(other: Amount) =
        Amount(this.amount + other.amount)

    operator fun minus(other: BigDecimal) =
        Amount(amount - other)

    operator fun minus(other: Amount) =
        Amount(amount - other.amount)

    /**
     * Multiply by a scalar.
     *
     * @param other       the value to multiply by
     * @return a new `BigDecimalAmount` representing this × other
     */
    operator fun times(other: Number) =
        Amount(amount.multiply(BigDecimal(other.toString()), DECIMAL128))

    /**
     * Divide by a scalar.
     *
     * @param other       the value to divide by
     * @return a new `BigDecimalAmount` representing this ÷ other
     */
    operator fun div(other: Number) =
        Amount(amount.divide(BigDecimal(other.toString()), DECIMAL128))

    /**
     * Elevate to power.
     *
     * @param power       the exponential factor
     * @return a new `BigDecimalAmount` representing `this`ⁿ
     */
    fun pow(power: Int) =
        Amount(amount.pow(power, DECIMAL128))

    /**
     * translate with scalar function.
     *
     * @param transformation a function representing a generic transformation from scalar to scalar
     * @return a new `BigDecimalAmount` with the transformed value
     */
    fun transformed(transformation: (Amount) -> Amount) =
        transformation(this)

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
        amount.toInt()

    /**
     * {@inheritDoc}
     */
    override fun toLong() =
        amount.toLong()

    /**
     * {@inheritDoc}
     */
    override fun toFloat() =
        amount.toFloat()

    /**
     * {@inheritDoc}
     */
    override fun toDouble() =
        amount.toDouble()

    /**
     * {@inheritDoc}
     */
    override fun toByte() =
        amount.toByte()

    /**
     * {@inheritDoc}
     */
    override fun toShort() =
        amount.toShort()

    /**
     * {@inheritDoc}
     */
    override fun toChar() =
        amount.toChar()

    // endregion

    // region implement Comparable

    override fun compareTo(other: Amount) =
        amount.compareTo(other.amount)

    // endregion
    // region override Object
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is Amount) return false
        return amount.stripTrailingZeros() == other.amount.stripTrailingZeros()
    }

    override fun hashCode() =
        amount.hashCode()

    override fun toString()
            : String =
        amount.stripTrailingZeros().toPlainString()

    // endregion

    companion object
    {
        @JvmField
        val ZERO = Amount(BigDecimal.ZERO)

        @JvmField
        val ONE = Amount(BigDecimal.ONE)
    }
}
