package pcb.uwu.core;

import pcb.uwu.core.UnitCounter.UnitCount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.Function;

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

	default CompositeUnitAmount<? extends Unit> multipliedBy(UnitAmount<? extends Unit> other, MathContext mathContext) {
		UnitCounter resultUnitCounter = new UnitCounter(getUnit().getUnitCounter());
		Function<BigDecimalAmount, BigDecimalAmount> transformation = Function.identity();

		for (UnitCount otherUnitCount : other.getUnit().getUnitCounter().getBaseUnits()) {
			UnitCount resultUnitCount = resultUnitCounter.get(otherUnitCount.getUnit());

			if (resultUnitCount == null) {
				// New unit type, no adaptation necessary
				resultUnitCounter.major(otherUnitCount.getUnit(), otherUnitCount.getCount());
				continue;
			}

			// Existing unit type, adaptation is necessary
			int resultMagnitude = resultUnitCount.getCount();
			int otherMagnitude = otherUnitCount.getCount();

			// other is major and this is major
			while (otherMagnitude > 0 && resultMagnitude > 0) {
				transformation = transformation
						.andThen(otherUnitCount.getUnit().getTranslationToCanonical())
						.andThen(resultUnitCount.getUnit().getTranslationFromCanonical());

				resultUnitCounter = resultUnitCounter.major(resultUnitCount.getUnit());

				resultMagnitude++;
				otherMagnitude--;
			}

			// other is minor and this is minor
			while (otherMagnitude < 0 && resultMagnitude < 0) {
				transformation = transformation
						.andThen(otherUnitCount.getUnit().getTranslationFromCanonical())
						.andThen(resultUnitCount.getUnit().getTranslationToCanonical());

				resultUnitCounter = resultUnitCounter.minor(resultUnitCount.getUnit());

				resultMagnitude--;
				otherMagnitude++;
			}

			// other is major and this is minor
			while (otherMagnitude > 0 && resultMagnitude < 0) {
				transformation = transformation
						.andThen(otherUnitCount.getUnit().getTranslationToCanonical())
						.andThen(resultUnitCount.getUnit().getTranslationFromCanonical());

				resultUnitCounter = resultUnitCounter.major(resultUnitCount.getUnit());

				resultMagnitude++;
				otherMagnitude--;
			}

			// other is minor and this is major
			while (otherMagnitude < 0 && resultMagnitude > 0) {
				transformation = transformation
						.andThen(otherUnitCount.getUnit().getTranslationFromCanonical())
						.andThen(resultUnitCount.getUnit().getTranslationToCanonical());

				resultUnitCounter = resultUnitCounter.minor(resultUnitCount.getUnit());

				resultMagnitude--;
				otherMagnitude++;
			}

			// other still exists and this is exhausted
			while (otherMagnitude > 0) {
				resultUnitCounter = resultUnitCounter.major(otherUnitCount.getUnit());

				otherMagnitude--;
			}

			// other still exists and this is exhausted
			while (otherMagnitude < 0) {
				resultUnitCounter = resultUnitCounter.minor(otherUnitCount.getUnit());

				otherMagnitude++;
			}
		}

		BigDecimalAmount resultAmount = transformation.apply(getAmount().multipliedBy(other.getAmount(), mathContext));

		return new CompositeUnitAmount<>(resultAmount, new CompositeUnit(resultUnitCounter));
	}

	default CompositeUnitAmount<? extends Unit> dividedBy(UnitAmount<? extends Unit> other, MathContext mathContext) {
		return multipliedBy(other.invert(mathContext), mathContext);
	}

	default CompositeUnitAmount<? extends Unit> invert(MathContext mathContext) {
		return new CompositeUnitAmount<>(
				getAmount().invert(mathContext),
				new CompositeUnit(getUnit().getUnitCounter().invert()));
	}

	/**
	 * Get the underlying {@code Amount} in a new {@code Unit}.
	 * @param unit the {@code Unit} to convert to
	 * @return the converted {@code Amount}
	 */
	BigDecimalAmount getAmountIn(U unit);

	UnitAmount<U> convertTo(U unit);
}
