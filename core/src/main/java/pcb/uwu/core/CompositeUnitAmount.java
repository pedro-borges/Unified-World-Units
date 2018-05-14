package pcb.uwu.core;

import pcb.uwu.core.UnitCounter.UnitCount;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;
import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

public class CompositeUnitAmount<U extends Unit> implements UnitAmount<U> {

	// region private fields

	private final BigDecimalAmount amount;
	private final U unit;

	// endregion

	// region constructors

	public CompositeUnitAmount(Number value, U unit) {
		this(value.toString(), unit);
	}

	public CompositeUnitAmount(Number value, Magnitude magnitude, U unit) {
		this(value.toString(), magnitude, unit);
	}

	public CompositeUnitAmount(String value, U unit) {
		this(new BigDecimal(value), unit);
	}

	public CompositeUnitAmount(String value, Magnitude magnitude, U unit) {
		this(new BigDecimal(value), magnitude, unit);
	}

	public CompositeUnitAmount(BigDecimal value, U unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public CompositeUnitAmount(BigDecimal value, Magnitude magnitude, U unit) {
		this(new BigDecimalAmount(value), magnitude, unit);
	}

	public CompositeUnitAmount(BigDecimalAmount amount, U unit) {
		this.amount = amount;
		this.unit = unit;
	}

	public CompositeUnitAmount(BigDecimalAmount amount, Magnitude magnitude, U unit) {
		this.amount = amount.multipliedBy(magnitude.getValue(), UNLIMITED);
		this.unit = unit;
	}

	// endregion

	// region implement Comparable

	@Override
	public int compareTo(UnitAmount<U> other) {
		BigDecimalAmount thisCanonical = this.getUnit().getTranslationToCanonical().apply(this.getAmount());
		BigDecimalAmount otherCanonical = other.getUnit().getTranslationToCanonical().apply(other.getAmount());

		return thisCanonical.getValue().compareTo(otherCanonical.getValue());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public BigDecimalAmount getAmount() {
		return amount;
	}

	@Override
	public U getUnit() {
		return unit;
	}

	@Override
	public UnitAmount<U> plus(UnitAmount<U> other, MathContext mathContext) {
		return new CompositeUnitAmount<>(UnitAmountUtils.plusAmount(this, other, mathContext), unit);
	}

	@Override
	public UnitAmount<U> minus(UnitAmount<U> other, MathContext mathContext) {
		return new CompositeUnitAmount<>(UnitAmountUtils.minusAmount(this, other, mathContext), unit);
	}

	@Override
	public UnitAmount<U> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new CompositeUnitAmount<>(UnitAmountUtils.multipliedByScalar(this, other, mathContext), unit);
	}

	@Override
	public UnitAmount<U> dividedBy(BigDecimal other, MathContext mathContext) {
		return new CompositeUnitAmount<>(UnitAmountUtils.dividedByScalar(this, other, mathContext), unit);
	}

	@Override
	public UnitAmount<? extends Unit> multipliedBy(UnitAmount<? extends Unit> other, MathContext mathContext) {
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
				if (!otherUnitCount.getUnit().equals(resultUnitCount.getUnit())) {
					transformation = transformation
							.andThen(otherUnitCount.getUnit().getTranslationToCanonical())
							.andThen(resultUnitCount.getUnit().getTranslationFromCanonical());
				}

				resultUnitCounter = resultUnitCounter.major(resultUnitCount.getUnit());

				resultMagnitude++;
				otherMagnitude--;
			}

			// other is minor and this is minor
			while (otherMagnitude < 0 && resultMagnitude < 0) {
				if (!otherUnitCount.getUnit().equals(resultUnitCount.getUnit())) {
					transformation = transformation
							.andThen(otherUnitCount.getUnit().getTranslationFromCanonical())
							.andThen(resultUnitCount.getUnit().getTranslationToCanonical());
				}

				resultUnitCounter = resultUnitCounter.minor(resultUnitCount.getUnit());

				resultMagnitude--;
				otherMagnitude++;
			}

			// other is major and this is minor
			while (otherMagnitude > 0 && resultMagnitude < 0) {
				if (!otherUnitCount.getUnit().equals(resultUnitCount.getUnit())) {
					transformation = transformation
							.andThen(otherUnitCount.getUnit().getTranslationToCanonical())
							.andThen(resultUnitCount.getUnit().getTranslationFromCanonical());
				}

				resultUnitCounter = resultUnitCounter.major(resultUnitCount.getUnit());

				resultMagnitude++;
				otherMagnitude--;
			}

			// other is minor and this is major
			while (otherMagnitude < 0 && resultMagnitude > 0) {
				if (!otherUnitCount.getUnit().equals(resultUnitCount.getUnit())) {
					transformation = transformation
							.andThen(otherUnitCount.getUnit().getTranslationFromCanonical())
							.andThen(resultUnitCount.getUnit().getTranslationToCanonical());
				}

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

	@Override
	public UnitAmount<? extends Unit> dividedBy(UnitAmount<? extends Unit> other, MathContext mathContext) {
		return multipliedBy(other.invert(mathContext), mathContext);
	}

	@Override
	public UnitAmount<? extends Unit> invert(MathContext mathContext) {
		return new CompositeUnitAmount<>(
				getAmount().invert(mathContext),
				new CompositeUnit(getUnit().getUnitCounter().invert()));
	}

	@Override
	public UnitAmount<U> in(U unit) {
		return new CompositeUnitAmount<>(getAmountIn(this, unit), unit);
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitAmount) {
			CompositeUnitAmount<?> that = (CompositeUnitAmount<?>) obj;

			return Objects.equals(this.amount, that.amount) &&
					Objects.equals(this.unit, that.unit);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, unit);
	}

	@Override
	public String toString() {
		return amount.toString() + (unit.isScalar() ? "" : " " + unit.toString());
	}

	// endregion
}
