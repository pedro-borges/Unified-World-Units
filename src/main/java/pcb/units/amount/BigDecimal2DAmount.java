package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.Function;

import static java.math.BigDecimal.ZERO;

public class BigDecimal2DAmount
		implements Amount<BigDecimal2DAmount> {
	// region private fields

	private final BigDecimal value1, value2;

	// endregion

	// region constructors

	public BigDecimal2DAmount(Number value1, Number value2) {
		this(value1.toString(), value2.toString());
	}

	public BigDecimal2DAmount(String value1, String value2) {
		this(new BigDecimal(value1), new BigDecimal(value2));
	}

	public BigDecimal2DAmount(BigDecimal value1, BigDecimal value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	// endregion

	// region implement Amount

	@Override
	public int getScale() {
		return Math.max(
				value1.scale(),
				value2.scale());
	}

	@Override
	public BigDecimal2DAmount withScale(int newScale, RoundingMode roundingMode) {
		return new BigDecimal2DAmount(
				value1.setScale(newScale, roundingMode),
				value2.setScale(newScale, roundingMode));
	}

	@Override
	public BigDecimal2DAmount plus(BigDecimal2DAmount other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				this.value1.add(other.value1, mathContext),
				this.value2.add(other.value2, mathContext));
	}

	@Override
	public BigDecimal2DAmount minus(BigDecimal2DAmount other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value1.subtract(other.value1, mathContext),
				value2.subtract(other.value2, mathContext));
	}

	@Override
	public BigDecimal2DAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value1.multiply(other, mathContext),
				value2.multiply(other, mathContext));
	}

	@Override
	public BigDecimal2DAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value1.divide(other, mathContext),
				value2.divide(other, mathContext));
	}

	@Override
	public BigDecimal2DAmount pow(int magnitude, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value1.pow(magnitude, mathContext),
				value2.pow(magnitude, mathContext));
	}

	@Override
	public BigDecimal2DAmount translated(Function<BigDecimal, BigDecimal> translation) {
		return new BigDecimal2DAmount(
				translation.apply(value1),
				translation.apply(value2));
	}

	// endregion

	public boolean isZero() {
		return (value1.compareTo(ZERO) == 0) && (value2.compareTo(ZERO) == 0);
	}

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Amount) {
			BigDecimal2DAmount other = (BigDecimal2DAmount) obj;

			return Objects.equals(this.value1, other.value1) &&
					Objects.equals(this.value2, other.value2);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value1, value2);
	}

	@Override
	public String toString() {
		return "[" + String.valueOf(value1) +
				", " + String.valueOf(value2) + "]";
	}

	// endregion
}
