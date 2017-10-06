package pcb.uwu.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;
import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;

public abstract class AbstractUnitAmount<U extends Unit> implements UnitAmount<U> {

	// region private fields

	private final BigDecimalAmount amount;
	private final U unit;

	// endregion

	// region constructors

	public AbstractUnitAmount(Number value, U unit) {
		this(value.toString(), unit);
	}

	public AbstractUnitAmount(Number value, Magnitude magnitude, U unit) {
		this(value.toString(), magnitude, unit);
	}

	public AbstractUnitAmount(String value, U unit) {
		this(new BigDecimal(value), unit);
	}

	public AbstractUnitAmount(String value, Magnitude magnitude, U unit) {
		this(new BigDecimal(value), magnitude, unit);
	}

	public AbstractUnitAmount(BigDecimal value, U unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public AbstractUnitAmount(BigDecimal value, Magnitude magnitude, U unit) {
		this(new BigDecimalAmount(value), magnitude, unit);
	}

	public AbstractUnitAmount(BigDecimalAmount amount, U unit) {
		this.amount = amount;
		this.unit = unit;
	}

	public AbstractUnitAmount(BigDecimalAmount amount, Magnitude magnitude, U unit) {
		this.amount = amount.multipliedBy(magnitude.getValue(), UNLIMITED);
		this.unit = unit;
	}

	// endregion

	// region protected methods

	protected BigDecimalAmount plusAmount(UnitAmount<U> other, MathContext mathContext) {
		return getAmount().plus(other.getAmountIn(getUnit()), mathContext);
	}

	protected BigDecimalAmount minusAmount(UnitAmount<U> other, MathContext mathContext) {
		return getAmount().minus(other.getAmountIn(getUnit()), mathContext);
	}

	protected BigDecimalAmount multipliedByScalar(BigDecimal other, MathContext mathContext) {
		return getAmount().multipliedBy(other, mathContext);
	}

	protected BigDecimalAmount dividedByScalar(BigDecimal other, MathContext mathContext) {
		return getAmount().dividedBy(other, mathContext);
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
	public BigDecimalAmount getAmountIn(U newUnit) {
		if (getUnit().equals(newUnit)) {
			return amount;
		}

		Function<BigDecimalAmount, BigDecimalAmount> translation = getUnit().getTranslationToCanonical().andThen(newUnit.getTranslationFromCanonical());

		return amount.transformed(translation);
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitAmount) {
			AbstractUnitAmount<?> other = (AbstractUnitAmount<?>) obj;

			return Objects.equals(this.amount, other.amount) &&
					Objects.equals(this.unit, other.unit);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, unit);
	}

	@Override
	public String toString() {
		return amount.toString() + unit.toString();
	}

	// endregion
}
