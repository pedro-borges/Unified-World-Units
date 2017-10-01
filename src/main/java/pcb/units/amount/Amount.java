package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

public class Amount extends Number {
	// region private fields

	private BigDecimal value;

	// endregion

	// region constructors

	public Amount(Number value) {
		this(value.toString());
	}

	public Amount(String value) {
		this(new BigDecimal(value));
	}

	public Amount(BigDecimal value) {
		this.value = value;
	}

	// endregion

	// region implement Amount

	public BigDecimal getValue() {
		return value;
	}

	public int getScale() {
		return value.scale();
	}

	public Amount withScale(int newScale, RoundingMode roundingMode) {
		return new Amount(value.setScale(newScale, roundingMode));
	}

	public boolean isPositive() {
		return value.compareTo(ZERO) > 0;
	}

	public boolean isZero() {
		return value.compareTo(ZERO) == 0;
	}

	public boolean isNegative() {
		return value.compareTo(ZERO) < 0;
	}

	public Amount plus(Amount other, MathContext mathContext) {
		return new Amount(this.value.add(other.getValue(), mathContext));
	}

	public Amount minus(Amount other, MathContext mathContext) {
		return new Amount(value.subtract(other.getValue(), mathContext));
	}

	public Amount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Amount(value.multiply(other, mathContext));
	}

	public Amount dividedBy(BigDecimal other, MathContext mathContext) {
		return new Amount(value.divide(other, mathContext));
	}

	public Amount dividedBy(Amount other, MathContext mathContext) {
		return new Amount(value.divide(other.getValue(), mathContext));
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

		Amount scaled = new Amount(value
				.movePointLeft(last.order())
				.stripTrailingZeros());

		return scaled.getValue().toPlainString() + last.symbol();
	}

	// endregion

	// region implement Number

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

	// override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Amount) {
			Amount other = (Amount) obj;

			return Objects.equals(this.getValue(), other.getValue());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value.toString();
	}

	// endregion
}
