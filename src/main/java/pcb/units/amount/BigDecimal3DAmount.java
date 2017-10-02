package pcb.units.amount;

import pcb.units.utils.MathUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.Function;

import static java.math.BigDecimal.ZERO;

public class BigDecimal3DAmount
		implements Amount<BigDecimal3DAmount> {
	// region private fields

	private final BigDecimal value1, value2, value3;

	// endregion

	// region constructors

	public BigDecimal3DAmount(Number value1, Number value2, Number value3) {
		this(value1.toString(), value2.toString(), value3.toString());
	}

	public BigDecimal3DAmount(String value1, String value2, String value3) {
		this(new BigDecimal(value1), new BigDecimal(value2), new BigDecimal(value3));
	}

	public BigDecimal3DAmount(BigDecimal value1, BigDecimal value2, BigDecimal value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

	// endregion

	// region implement Amount

	@Override
	public int getScale() {
		return MathUtils.max(
				value1.scale(),
				value2.scale(),
				value3.scale());
	}

	@Override
	public BigDecimal3DAmount withScale(int newScale, RoundingMode roundingMode) {
		return new BigDecimal3DAmount(
				value1.setScale(newScale, roundingMode),
				value2.setScale(newScale, roundingMode),
				value3.setScale(newScale, roundingMode));
	}

	@Override
	public BigDecimal3DAmount plus(BigDecimal3DAmount other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				this.value1.add(other.value1, mathContext),
				this.value2.add(other.value2, mathContext),
				this.value3.add(other.value3, mathContext));
	}

	@Override
	public BigDecimal3DAmount minus(BigDecimal3DAmount other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value1.subtract(other.value1, mathContext),
				value2.subtract(other.value2, mathContext),
				value3.subtract(other.value3, mathContext));
	}

	@Override
	public BigDecimal3DAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value1.multiply(other, mathContext),
				value2.multiply(other, mathContext),
				value3.multiply(other, mathContext));
	}

	@Override
	public BigDecimal3DAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value1.divide(other, mathContext),
				value2.divide(other, mathContext),
				value3.divide(other, mathContext));
	}

	@Override
	public BigDecimal3DAmount pow(int magnitude, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value1.pow(magnitude, mathContext),
				value2.pow(magnitude, mathContext),
				value3.pow(magnitude, mathContext));
	}

	@Override
	public BigDecimal3DAmount translated(Function<BigDecimal, BigDecimal> translation) {
		return new BigDecimal3DAmount(
				translation.apply(value1),
				translation.apply(value2),
				translation.apply(value3));
	}

	// endregion

	public boolean isZero() {
		return (value1.compareTo(ZERO) == 0) &&
				(value2.compareTo(ZERO) == 0) &&
				(value3.compareTo(ZERO) == 0);
	}

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Amount) {
			BigDecimal3DAmount other = (BigDecimal3DAmount) obj;

			return Objects.equals(this.value1, other.value1) &&
					Objects.equals(this.value2, other.value2) &&
					Objects.equals(this.value3, other.value3);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value1, value2, value3);
	}

	@Override
	public String toString() {
		return "[" + String.valueOf(value1) +
				", " + String.valueOf(value2) +
				", " + String.valueOf(value3) + "]";
	}

	// endregion
}
