package pcb.uwu.core;

import java.math.BigDecimal;
import java.math.MathContext;

public interface UnitAmount<U extends Unit> extends Comparable<UnitAmount<U>> {
	/**
	 * @return the underlying {@code Amount}
	 */
	BigDecimalAmount getAmount();

	/**
	 * @return the underlrying {@code Unit}
	 */
	U getUnit();

	/**
	 * Sum another {@code UnitAmount} to this {@code UnitAmount} using unit conversion when necessary.
	 * @param other the {@code UnitAmount} to add
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this + other
	 */
	UnitAmount<U> plus(UnitAmount<U> other, MathContext mathContext);

	/**
	 * Subtract another {@code UnitAmount} from this {@code UnitAmount} using unit conversion when necessary.
	 * @param other the {@code UnitAmount} to subtract
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this - other
	 */
	UnitAmount<U> minus(UnitAmount<U> other, MathContext mathContext);

	/**
	 * Multiply this {@code UnitAmount} by a scalar value.
	 * @param other the scalar value to multiply by
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this × other
	 */
	UnitAmount<U> multipliedBy(BigDecimal other, MathContext mathContext);

	/**
	 * Divide this {@code UnitAmount} by a scalar value.
	 * @param other the scalar value to divide by
	 * @param mathContext the maths context to consider
	 * @return a new {@code AmountUnit} in this {@code Unit} representing this ÷ other
	 */
	UnitAmount<U> dividedBy(BigDecimal other, MathContext mathContext);

	UnitAmount<? extends Unit> multipliedBy(UnitAmount<? extends Unit> other, MathContext mathContext);

	UnitAmount<? extends Unit> dividedBy(UnitAmount<? extends Unit> other, MathContext mathContext);

	UnitAmount<? extends Unit> invert(MathContext mathContext);

	/**
	 * Get the {@code UnitAmount} in a new {@code Unit}.
	 * @param unit the {@code Unit} to convert to
	 * @return the converted {@code UnitAmount}
	 */
	UnitAmount<U> in(U unit);

	/**
	 * Compares two {@code UnitAmount} relaxing to base units
	 * i.e. 300 seconds is equivalent to 5 minutes
	 * @return true if equivalent, false otherwise
	 */
	boolean equivalentTo(UnitAmount<?> unitAmount);
}
