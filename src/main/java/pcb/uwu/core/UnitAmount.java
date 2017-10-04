package pcb.uwu.core;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Represents an amount in a specific unit.
 * @param <A> The {@code Amount}
 * @param <U> The {@code Unit}
 */
public interface UnitAmount<A extends Amount<A>, U extends Unit> {
	/**
	 * @return the underlying {@code Amount}
	 */
	A getAmount();

	/**
	 * @return the undelrying {@code Unit}
	 */
	U getUnit();

	/**
	 * Sum another {@code UnitAmount} to this {@code UnitAmount} using unit conversion when necessary.
	 * @param other the {@code UnitAmount} to add
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this + other
	 */
	UnitAmount<A, U> plus(UnitAmount<A, U> other, MathContext mathContext);

	/**
	 * Subtract another {@code UnitAmount} from this {@code UnitAmount} using unit conversion when necessary.
	 * @param other the {@code UnitAmount} to subtract
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this - other
	 */
	UnitAmount<A, U> minus(UnitAmount<A, U> other, MathContext mathContext);

	/**
	 * Multiply this {@code UnitAmount} by a scalar value.
	 * @param other the scalar value to multiply by
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this × other
	 */
	UnitAmount<A, U> multipliedBy(BigDecimal other, MathContext mathContext);

	/**
	 * Divide this {@code UnitAmount} by a scalar value.
	 * @param other the scalar value to divide by
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this ÷ other
	 */
	UnitAmount<A, U> dividedBy(BigDecimal other, MathContext mathContext);

	/**
	 * Get the underlying {@code Amount} in a new {@code Unit}.
	 * @param unit the {@code Unit} to convert to
	 * @return the converted {@code Amount}
	 */
	A getAmountIn(U unit);
}
