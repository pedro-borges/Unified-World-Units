package pcb.uwu.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;

/**
 * An implementation of Amount for uni-dimensional values based on {@code java.lang.BigDecimal} representation.
 */
public class BigDecimalAmount extends Number implements Comparable<BigDecimalAmount> {

	// region fields

	public static final BigDecimalAmount ZERO = new BigDecimalAmount(0);
	public static final BigDecimalAmount ONE = new BigDecimalAmount(1);

	private final BigDecimal value;

	// endregion

	// region constructors

	public BigDecimalAmount(Number value) {
		this(value.toString());
	}

	public BigDecimalAmount(String value) {
		this(new BigDecimal(value));
	}

	public BigDecimalAmount(BigDecimal value) {
		this.value = value;
	}

	// endregion

	// region public methods

	/**
	 * The scalar representation of this {@code BigDecimalAmount}.
	 *
	 * @return the underlying value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * The scale of this {@code BigDecimalAmount}.
	 *
	 * @return the scale of the {@code BigDecimalAmount}
	 */
	public int getScale() {
		return value.scale();
	}

	/**
	 * Set the scale of the {@code BigDecimalAmount}.
	 *
	 * @param scale the new scale to set
	 * @param roundingMode the rounding mode
	 * @return a new Amount with the new scale
	 */
	public BigDecimalAmount withScale(int scale, RoundingMode roundingMode) {
		return new BigDecimalAmount(value.setScale(scale, roundingMode));
	}

	public BigDecimalAmount invert(MathContext mathContext) {
		return new BigDecimalAmount(ONE.dividedBy(this, mathContext));
	}

	/**
	 * Sum amount.
	 * @param other the {@code BigDecimalAmount} to add
	 * @return a new {@code BigDecimalAmount} representing this + other
	 */
	public BigDecimalAmount plus(BigDecimal other) {
		return new BigDecimalAmount(this.value.add(other));
	}

	/**
	 * Sum amount.
	 * @param other the {@code BigDecimalAmount} to add
	 * @param mathContext the maths context to consider
	 * @return a new {@code BigDecimalAmount} representing this + other
	 */
	public BigDecimalAmount plus(BigDecimalAmount other, MathContext mathContext) {
		return new BigDecimalAmount(this.value.add(other.value, mathContext));
	}

	/**
	 * Subtract amount.
	 * @param other the {@code BigDecimalAmount} to subtract
	 * @return a new {@code BigDecimalAmount} representing this - other
	 */
	public BigDecimalAmount minus(BigDecimal other) {
		return new BigDecimalAmount(value.subtract(other));
	}

	/**
	 * Subtract amount.
	 * @param other the {@code BigDecimalAmount} to subtract
	 * @param mathContext the maths context to consider
	 * @return a new {@code BigDecimalAmount} representing this - other
	 */
	public BigDecimalAmount minus(BigDecimalAmount other, MathContext mathContext) {
		return new BigDecimalAmount(value.subtract(other.value, mathContext));
	}

	/**
	 * Multiply by a scalar.
	 * @param other the short value to multiply by
	 * @return a new {@code BigDecimalAmount} representing this × other
	 */
	public BigDecimalAmount multipliedBy(short other) {
		return multipliedBy(other, UNLIMITED);
	}

	/**
	 * Multiply by a scalar.
	 * @param other the int value to multiply by
	 * @return a new {@code BigDecimalAmount} representing this × other
	 */
	public BigDecimalAmount multipliedBy(int other) {
		return multipliedBy(other, UNLIMITED);
	}

	/**
	 * Multiply by a scalar.
	 * @param other the long value to multiply by
	 * @return a new {@code BigDecimalAmount} representing this × other
	 */
	public BigDecimalAmount multipliedBy(long other) {
		return multipliedBy(other, UNLIMITED);
	}

	/**
	 * Multiply by a scalar.
	 * @param other the value to multiply by
	 * @param mathContext the maths context to consider
	 * @return a new {@code BigDecimalAmount} representing this × other
	 */
	public BigDecimalAmount multipliedBy(Number other, MathContext mathContext) {
		return multipliedBy(new BigDecimal(other.toString()), mathContext);
	}

	/**
	 * Multiply by a scalar.
	 * @param other the value to multiply by
	 * @param mathContext the maths context to consider
	 * @return a new {@code BigDecimalAmount} representing this × other
	 */
	public BigDecimalAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.multiply(other, mathContext));
	}

	/**
	 * Multiply by a scalar.
	 * @param other the {@code BigDecimalAmount} to multiply by
	 * @param mathContext the maths context to consider
	 * @return the scalar result of dividing this {@code BigDecimalAmount} but another.
	 */
	public BigDecimalAmount multipliedBy(BigDecimalAmount other, MathContext mathContext) {
		return multipliedBy(other.value, mathContext);
	}

	/**
	 * Divide by a scalar.
	 * @param other the value to divide by
	 * @param mathContext the maths context to consider
	 * @return a new {@code BigDecimalAmount} representing this ÷ other
	 */
	public BigDecimalAmount dividedBy(Number other, MathContext mathContext) {
		return dividedBy(new BigDecimal(other.toString()), mathContext);
	}

	/**
	 * Divide by a scalar.
	 * @param other the value to divide by
	 * @param mathContext the maths context to consider
	 * @return the scalar result of dividing this {@code BigDecimalAmount} but another.
	 */
	public BigDecimalAmount dividedBy(BigDecimalAmount other, MathContext mathContext) {
		return dividedBy(other.value, mathContext);
	}

	/**
	 * Divide by a scalar.
	 * @param other the value to divide by
	 * @param mathContext the maths context to consider
	 * @return a new {@code BigDecimalAmount} representing this ÷ other
	 */
	public BigDecimalAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.divide(other, mathContext));
	}

	/**
	 * Elevate to power.
	 * @param power the exponential factor
	 * @param mathContext the maths context to consider
	 * @return a new {@code BigDecimalAmount} representing {@code this}ⁿ
	 */
	public BigDecimalAmount pow(int power, MathContext mathContext) {
		return new BigDecimalAmount(value.pow(power, mathContext));
	}

	/**
	 * translate with scalar function.
	 *
	 * @param transformation a function representing a generic transformation from scalar to scalar
	 * @return a new {@code BigDecimalAmount} with the transformed value
	 */
	public BigDecimalAmount transformed(Function<BigDecimalAmount, BigDecimalAmount> transformation) {
		return transformation.apply(this);
	}

	/**
	 * Check if this {@code BigDecimalAmount} is zero.
	 *
	 * @return true if this {@code Amount} is zero, false otherwise
	 */
	public boolean isZero() {
		return compareTo(ZERO) == 0;
	}

	/**
	 * Check if this {@code BigDecimalAmount} is positive.
	 *
	 * @return true if this {@code BigDecimalAmount} is positive, false otherwise
	 */
	public boolean isPositive() {
		return compareTo(ZERO) > 0;
	}

	/**
	 * Check if this {@code BigDecimalAmount} is negative.
	 *
	 * @return true if this {@code BigDecimalAmount} is negative, false otherwise
	 */
	public boolean isNegative() {
		return compareTo(ZERO) < 0;
	}

	// endregion

	// region representation

//	public String toStringWithMagnitude(List<Magnitude> magnitudes) {
//		if (isZero() || magnitudes.isEmpty())
//		{
//			return value.toPlainString();
//		}
//
//		Magnitude last;
//		BigDecimal absolute = value.abs();
//
//		if (absolute.compareTo(BigDecimal.ONE) == 0) {
//			return value.toPlainString();
//		} else if (absolute.compareTo(BigDecimal.ONE) > 0) {
//			last = magnitudes.get(0);
//			for (int i = 0; i < magnitudes.size(); i++) {
//				if (absolute.compareTo(magnitudes.get(i).getValue()) < 0) break;
//				last = magnitudes.get(i);
//			}
//		} else {
//			last = magnitudes.get(magnitudes.size() - 1);
//			for (int i = magnitudes.size() - 1; i >= 0; i--) {
//				last = magnitudes.get(i);
//				if (absolute.compareTo(magnitudes.get(i).getValue()) >= 0) break;
//			}
//		}
//
//		BigDecimalAmount scaled = new BigDecimalAmount(value
//				.movePointLeft(last.order())
//				.stripTrailingZeros());
//
//		return scaled.value.toPlainString() + last.symbol();
//	}

	// endregion

	// region extend Number

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int intValue() {
		return value.intValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long longValue() {
		return value.longValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float floatValue() {
		return value.floatValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte byteValue() {
		return value.byteValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public short shortValue() {
		return value.shortValue();
	}

	// endregion

	// region implement Comparable

	@Override
	public int compareTo(BigDecimalAmount other) {
		return this.value.compareTo(other.value);
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BigDecimalAmount) {
			BigDecimalAmount that = (BigDecimalAmount) obj;

			return this.value.equals(that.value);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value.toPlainString();
	}

	// endregion
}
