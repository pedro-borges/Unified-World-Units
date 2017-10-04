package pcb.uwu.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.Function;

import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL64;

/**
 * An implementation of Amount for bi-dimensional values based on {@code java.lang.BigDecimal} representations.
 */
public class BigDecimal2DAmount
		implements Amount<BigDecimal2DAmount> {

	// region inner classes

	/**
	 * The dimensions of a tri-dimensional amount
	 *
	 * Can either be seen as [A, B] or as [X, Y]
	 */
	public enum Dimension2D implements Dimension<BigDecimal2DAmount> {
		A(0),
		X(0),
		B(1),
		Y(1);

		private final int index;

		Dimension2D(int index) {
			this.index = index;
		}

		@Override
		public int index() {
			return index;
		}
	}

	// endregion

	// region private fields

	private final BigDecimal[] value = new BigDecimal[2];

	// endregion

	// region constructors

	public BigDecimal2DAmount(Number valueA, Number valueB) {
		this(valueA.toString(), valueB.toString());
	}

	public BigDecimal2DAmount(String valueA, String valueB) {
		this(new BigDecimal(valueA), new BigDecimal(valueB));
	}

	public BigDecimal2DAmount(BigDecimal valueA, BigDecimal valueB) {
		this.value[0] = valueA;
		this.value[1] = valueB;
	}

	// endregion

	// region implement Amount

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getValue() {
		return value[0].pow(2).add(value[1].pow(2)).pow(-2, DECIMAL64);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getValue(Dimension<BigDecimal2DAmount> dimension) {
		return value[dimension.index()];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getScale() {
		return Math.max(
				value[0].scale(),
				value[1].scale());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal2DAmount withScale(int scale, RoundingMode roundingMode) {
		return new BigDecimal2DAmount(
				value[0].setScale(scale, roundingMode),
				value[1].setScale(scale, roundingMode));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal2DAmount plus(BigDecimal2DAmount other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				this.value[0].add(other.value[0], mathContext),
				this.value[1].add(other.value[1], mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal2DAmount minus(BigDecimal2DAmount other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].subtract(other.value[0], mathContext),
				value[1].subtract(other.value[1], mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal2DAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].multiply(other, mathContext),
				value[1].multiply(other, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal2DAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].divide(other, mathContext),
				value[1].divide(other, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal2DAmount pow(int n, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].pow(n, mathContext),
				value[1].pow(n, mathContext));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal2DAmount translated(Function<BigDecimal, BigDecimal> transformation) {
		return new BigDecimal2DAmount(
				transformation.apply(value[0]),
				transformation.apply(value[1]));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isZero() {
		return (value[0].compareTo(ZERO) == 0) && (value[1].compareTo(ZERO) == 0);
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Amount) {
			BigDecimal2DAmount other = (BigDecimal2DAmount) obj;

			return Objects.equals(this.value[0], other.value[0]) &&
					Objects.equals(this.value[1], other.value[1]);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value[0], value[1]);
	}

	@Override
	public String toString() {
		return "[" + String.valueOf(value[0]) +
				", " + String.valueOf(value[1]) + "]";
	}

	// endregion
}
