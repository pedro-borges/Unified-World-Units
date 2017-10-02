package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.Function;

import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL64;

public class BigDecimal2DAmount
		implements Amount<BigDecimal2DAmount> {

	// region inner classes

	public enum AmountLabel2D implements AmountLabel<BigDecimal2DAmount> {
		A(0),
		X(0),
		B(1),
		Y(1);

		private final int index;

		AmountLabel2D(int index) {
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

	@Override
	public BigDecimal getValue() {
		return value[0].pow(2).add(value[1].pow(2)).pow(-2, DECIMAL64);
	}

	@Override
	public BigDecimal getValue(AmountLabel<BigDecimal2DAmount> label) {
		return value[label.index()];
	}

	@Override
	public int getScale() {
		return Math.max(
				value[0].scale(),
				value[1].scale());
	}

	@Override
	public BigDecimal2DAmount withScale(int newScale, RoundingMode roundingMode) {
		return new BigDecimal2DAmount(
				value[0].setScale(newScale, roundingMode),
				value[1].setScale(newScale, roundingMode));
	}

	@Override
	public BigDecimal2DAmount plus(BigDecimal2DAmount other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				this.value[0].add(other.value[0], mathContext),
				this.value[1].add(other.value[1], mathContext));
	}

	@Override
	public BigDecimal2DAmount minus(BigDecimal2DAmount other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].subtract(other.value[0], mathContext),
				value[1].subtract(other.value[1], mathContext));
	}

	@Override
	public BigDecimal2DAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].multiply(other, mathContext),
				value[1].multiply(other, mathContext));
	}

	@Override
	public BigDecimal2DAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].divide(other, mathContext),
				value[1].divide(other, mathContext));
	}

	@Override
	public BigDecimal2DAmount pow(int magnitude, MathContext mathContext) {
		return new BigDecimal2DAmount(
				value[0].pow(magnitude, mathContext),
				value[1].pow(magnitude, mathContext));
	}

	@Override
	public BigDecimal2DAmount translated(Function<BigDecimal, BigDecimal> translation) {
		return new BigDecimal2DAmount(
				translation.apply(value[0]),
				translation.apply(value[1]));
	}

	// endregion

	public boolean isZero() {
		return (value[0].compareTo(ZERO) == 0) && (value[1].compareTo(ZERO) == 0);
	}

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
