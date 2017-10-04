package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

/**
 * An implementation of Amount for uni-dimensional values based on {@code java.lang.BigDecimal} representation.
 */
public class BigDecimalAmount
		extends Number
		implements Amount<BigDecimalAmount> {

	/**
	 * The identity amount i.e. 1
	 */
	public static final BigDecimalAmount IDENTITY = new BigDecimalAmount(1);

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getValue(Dimension<BigDecimalAmount> dimension) {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getScale() {
		return value.scale();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimalAmount withScale(int scale, RoundingMode roundingMode) {
		return new BigDecimalAmount(value.setScale(scale, roundingMode));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimalAmount plus(BigDecimalAmount other, MathContext mathContext) {
		return new BigDecimalAmount(this.value.add(other.value, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimalAmount minus(BigDecimalAmount other, MathContext mathContext) {
		return new BigDecimalAmount(value.subtract(other.value, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimalAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.multiply(other, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimalAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.divide(other, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimalAmount pow(int n, MathContext mathContext) {
		return new BigDecimalAmount(value.pow(n, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimalAmount translated(Function<BigDecimal, BigDecimal> transformation) {
		return new BigDecimalAmount(transformation.apply(value));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isZero() {
		return value.compareTo(ZERO) == 0;
	}

	// endregion

	public BigDecimal dividedBy(BigDecimalAmount other, MathContext mathContext) {
		return value.divide(other.value, mathContext);
	}

	public boolean isPositive() {
		return value.compareTo(ZERO) > 0;
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
