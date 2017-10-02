package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

public class BigDecimalAmount
		extends Number
		implements Amount<BigDecimalAmount> {
	// region private fields

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

	// region implement Amount

	@Override
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public int getScale() {
		return value.scale();
	}

	@Override
	public BigDecimalAmount withScale(int newScale, RoundingMode roundingMode) {
		return new BigDecimalAmount(value.setScale(newScale, roundingMode));
	}

	@Override
	public BigDecimalAmount plus(BigDecimalAmount other, MathContext mathContext) {
		return new BigDecimalAmount(this.value.add(other.value, mathContext));
	}

	@Override
	public BigDecimalAmount minus(BigDecimalAmount other, MathContext mathContext) {
		return new BigDecimalAmount(value.subtract(other.value, mathContext));
	}

	@Override
	public BigDecimalAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.multiply(other, mathContext));
	}

	@Override
	public BigDecimalAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.divide(other, mathContext));
	}

	@Override
	public BigDecimalAmount pow(int magnitude, MathContext mathContext) {
		return new BigDecimalAmount(value.pow(magnitude, mathContext));
	}

	public BigDecimal dividedBy(BigDecimalAmount other, MathContext mathContext) {
		return value.divide(other.value, mathContext);
	}

	@Override
	public BigDecimalAmount translated(Function<BigDecimal, BigDecimal> translation) {
		return new BigDecimalAmount(translation.apply(value));
	}

	// endregion

	public boolean isPositive() {
		return value.compareTo(ZERO) > 0;
	}

	public boolean isZero() {
		return value.compareTo(ZERO) == 0;
	}

	public boolean isNegative() {
		return value.compareTo(ZERO) < 0;
	}

	public String toDecimalPrefixedString(List<Magnitude> magnitudes) {
		if (isZero() || magnitudes.isEmpty())
		{
			return value.toPlainString();
		}

		Magnitude last;
		BigDecimal absolute = value.abs();

		if (absolute.compareTo(ONE) == 0) {
			return value.toPlainString();
		} else if (absolute.compareTo(ONE) > 0) {
			last = magnitudes.get(0);
			for (int i = 0; i < magnitudes.size(); i++) {
				if (absolute.compareTo(magnitudes.get(i).getValue()) < 0) break;
				last = magnitudes.get(i);
			}
		} else {
			last = magnitudes.get(magnitudes.size() - 1);
			for (int i = magnitudes.size() - 1; i >= 0; i--) {
				last = magnitudes.get(i);
				if (absolute.compareTo(magnitudes.get(i).getValue()) > 0) break;
			}
		}

		BigDecimalAmount scaled = new BigDecimalAmount(value
				.movePointLeft(last.order())
				.stripTrailingZeros());

		return scaled.value.toPlainString() + last.symbol();
	}

	// region extend Number

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public byte byteValue() {
		return value.byteValue();
	}

	@Override
	public short shortValue() {
		return value.shortValue();
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Amount) {
			BigDecimalAmount other = (BigDecimalAmount) obj;

			return Objects.equals(this.value, other.value);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	// endregion
}
