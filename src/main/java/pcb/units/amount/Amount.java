package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.Function;

/**
 * Represents an amount, or quantity.
 * @param <A> the concrete type of the {@code Amount}
 */
public interface Amount<A extends Amount<A>> {
	interface Dimension<A> {
		int index();
	}

	/**
	 * The scalar representation of this {@code Amount}.
	 *
	 * If the {@code Amount} is uni-dimensional it returns the underlying Amount.
	 *
	 * If the {@code Amount} is multi-dimensional it returns the norm of the Amount.
	 *
	 * @return the underlying value
	 */
	BigDecimal getValue();

	/**
	 * The scalar representation of this {@code Amount}.
	 *
	 * If the {@code Amount} is uni-dimensional it returns the underlying value.
	 *
	 * If the {@code Amount} is multi-dimensional it returns the value of the selected dimension.
	 *
	 * @param dimension the dimension to consider
	 * @return the underlying value
	 */
	BigDecimal getValue(Dimension<A> dimension);

	/**
	 * The scale of this {@code Amount}.
	 *
	 * If the {@code Amount} is uni-dimensional it returns it's scale.
	 *
	 * If the {@code Amount} is multi-dimensional it returns the largest scale of it's individual dimensions.
	 *
	 * @return the scale of the {@code Amount}
	 */
	int getScale();

	/**
	 * Set the scale of the {@code Amount}.
	 *
	 * If the {@code Amount} is multi-dimensional all dimensions will be affected with the new scale.
	 *
	 * @param scale the new scale to set
	 * @param roundingMode the rounding mode
	 * @return a new Amount with the new scale
	 */
	A withScale(int scale, RoundingMode roundingMode);

	/**
	 * Sum amount.
	 * @param other the {@code Amount} to add
	 * @param mathContext the maths context to consider
	 * @return a new {@code Amount} representing this + other
	 */
	A plus(A other, MathContext mathContext);

	/**
	 * Subtract amount.
	 * @param other the Amount to subtract
	 * @param mathContext the maths context to consider
	 * @return a new Amount representing this - other
	 */
	A minus(A other, MathContext mathContext);

	/**
	 * Multiply by a scalar.
	 * @param other the scalar value to multiply by
	 * @param mathContext the maths context to consider
	 * @return a new {@code Amount} representing this × other
	 */
	A multipliedBy(BigDecimal other, MathContext mathContext);

	/**
	 * Divide by a scalar.
	 * @param other the scalar value to divide by
	 * @param mathContext the maths context to consider
	 * @return a new Amount representing this ÷ other
	 */
	A dividedBy(BigDecimal other, MathContext mathContext);

	/**
	 * Elevate to power.
	 * @param n the exponential factor
	 * @param mathContext the maths context to consider
	 * @return a new {@code Amount} representing thisⁿ
	 */
	A pow(int n, MathContext mathContext);

	/**
	 * translate with scalar function
	 *
	 * If the {@code Amount} is multi-dimensional all dimensions will be translated individually
	 * 
	 * @param transformation a function representing a generic transformation from scalar to scalar 
	 * @return a new {@code Amount} with the transformed value
	 */
	A translated(Function<BigDecimal, BigDecimal> transformation);

	/**
	 * @return true if this {@code Amount} is zero, false otherwise
	 */
	boolean isZero();
}
