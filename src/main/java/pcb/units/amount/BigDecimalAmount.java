package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static pcb.units.amount.Magnitude.NATURAL;

public class BigDecimalAmount extends Amount<BigDecimal> {
	// region private fields

	private BigDecimal value;
	private Magnitude magnitude;

	// endregion

	// region private helpers
//
//	private static BigDecimal toBigDecimal(Number number) {
//		if (number instanceof BigDecimal) {
//			return (BigDecimal) number;
//		} else {
//			return new BigDecimal(number.toString());
//		}
//	}

	// endregion

	// region constructors

	public BigDecimalAmount(Number value) {
		this(value.toString());
	}

	public BigDecimalAmount(String value) {
		this(new BigDecimal(value));
	}

	public BigDecimalAmount(BigDecimal value) {
		this(value, NATURAL);
	}

	public BigDecimalAmount(Number value, Magnitude magnitude) {
		this(new BigDecimal(value.toString()), magnitude);
	}

	public BigDecimalAmount(BigDecimal value, Magnitude magnitude) {
		this.value = value;
		this.magnitude = magnitude;
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
	public BigDecimalAmount withScale(int scale, RoundingMode roundingMode) {
		return new BigDecimalAmount(value.setScale(scale, roundingMode));
	}

	@Override
	public Magnitude getMagnitude() {
		return magnitude;
	}

	@Override
	public BigDecimalAmount withMagnitude(Magnitude magnitude) {
		int shift = this.magnitude.order() - magnitude.order();
		return new BigDecimalAmount(value.scaleByPowerOfTen(shift).stripTrailingZeros(), magnitude);
	}

	@Override
	public BigDecimalAmount withAutoMagnitude() {
		Magnitude last = Magnitude.values()[0];

		for (Magnitude magnitude : Magnitude.values()) {
			last = magnitude;
			if (value.compareTo(magnitude.getValue()) < 0) break;
		}

		return this.withMagnitude(last);
	}

	@Override
	public Amount<BigDecimal> plus(Amount<BigDecimal> other, MathContext mathContext) {
		BigDecimal otherInThisMagnitude = other.withMagnitude(this.magnitude).getValue();
		return new BigDecimalAmount(this.value.add(otherInThisMagnitude, mathContext), this.magnitude);
	}

	@Override
	public Amount<BigDecimal> minus(Amount<BigDecimal> other, MathContext mathContext) {
		BigDecimal otherInThisMagnitude = other.withMagnitude(this.magnitude).getValue();
		return new BigDecimalAmount(value.subtract(otherInThisMagnitude, mathContext), this.magnitude);
	}

	@Override
	public Amount<BigDecimal> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimalAmount(value.multiply(other, mathContext), this.magnitude);
	}

	@Override
	public Amount<BigDecimal> dividedBy(BigDecimal other, MathContext mathContext) {
		BigDecimal quotient = value.divide(other, mathContext);
		return new BigDecimalAmount(quotient, this.magnitude);
	}

	@Override
	public Amount<BigDecimal> dividedBy(Amount<BigDecimal> other, MathContext mathContext) {
		return new BigDecimalAmount(value.divide(other.getValue(), mathContext));
	}

	// endregion

	// region implement Number

	@Override
	public int intValue() {
		return withMagnitude(NATURAL).value.intValue();
	}

	@Override
	public long longValue() {
		return withMagnitude(NATURAL).value.longValue();
	}

	@Override
	public float floatValue() {
		return withMagnitude(NATURAL).value.floatValue();
	}

	@Override
	public double doubleValue() {
		return withMagnitude(NATURAL).value.doubleValue();
	}

	@Override
	public byte byteValue() {
		return withMagnitude(NATURAL).value.byteValue();
	}

	@Override
	public short shortValue() {
		return withMagnitude(NATURAL).value.shortValue();
	}

	// endregion

	@Override
	public String toString() {
		return value.toPlainString() + magnitude.symbol();
	}
}
