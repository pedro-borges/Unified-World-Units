package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

public class BigDecimalAmount extends Amount<BigDecimal> {
	// region private fields

	private BigDecimal value;

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
	public boolean isPositive() {
		return value.compareTo(ZERO) > 0;
	}

	@Override
	public boolean isZero() {
		return value.compareTo(ZERO) == 0;
	}

	@Override
	public boolean isNegative() {
		return value.compareTo(ZERO) < 0;
	}

	@Override
	public Amount<BigDecimal> plus(Amount<BigDecimal> other, MathContext mathContext) {
		return new BigDecimalAmount(this.value.add(other.getValue(), mathContext));
	}

	@Override
	public Amount<BigDecimal> minus(Amount<BigDecimal> other, MathContext mathContext) {
		return new BigDecimalAmount(value.subtract(other.getValue(), mathContext));
	}

	@Override
	public Amount<BigDecimal> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.multiply(other, mathContext));
	}

	@Override
	public Amount<BigDecimal> dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.divide(other, mathContext));
	}

	@Override
	public Amount<BigDecimal> dividedBy(Amount<BigDecimal> other, MathContext mathContext) {
		return new BigDecimalAmount(value.divide(other.getValue(), mathContext));
	}

	@Override
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
	public String toString() {
		return value.toString();
	}

	// endregion
}
