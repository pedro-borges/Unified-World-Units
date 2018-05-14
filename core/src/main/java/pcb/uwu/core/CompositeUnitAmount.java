package pcb.uwu.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;
import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;

public class CompositeUnitAmount<U extends Unit> implements UnitAmount<U> {

	// region private fields

	private final BigDecimalAmount amount;
	private final U unit;

	// endregion

	// region constructors

	public CompositeUnitAmount(Number value, U unit) {
		this(value.toString(), unit);
	}

	public CompositeUnitAmount(Number value, Magnitude magnitude, U unit) {
		this(value.toString(), magnitude, unit);
	}

	public CompositeUnitAmount(String value, U unit) {
		this(new BigDecimal(value), unit);
	}

	public CompositeUnitAmount(String value, Magnitude magnitude, U unit) {
		this(new BigDecimal(value), magnitude, unit);
	}

	public CompositeUnitAmount(BigDecimal value, U unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public CompositeUnitAmount(BigDecimal value, Magnitude magnitude, U unit) {
		this(new BigDecimalAmount(value), magnitude, unit);
	}

	public CompositeUnitAmount(BigDecimalAmount amount, U unit) {
		this.amount = amount;
		this.unit = unit;
	}

	public CompositeUnitAmount(BigDecimalAmount amount, Magnitude magnitude, U unit) {
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
	public UnitAmount<U> plus(UnitAmount<U> other, MathContext mathContext) {
		return new CompositeUnitAmount<>(plusAmount(other, mathContext), unit);
	}

	@Override
	public UnitAmount<U> minus(UnitAmount<U> other, MathContext mathContext) {
		return new CompositeUnitAmount<>(minusAmount(other, mathContext), unit);
	}

	@Override
	public UnitAmount<U> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new CompositeUnitAmount<>(multipliedByScalar(other, mathContext), unit);
	}

	@Override
	public UnitAmount<U> dividedBy(BigDecimal other, MathContext mathContext) {
		return new CompositeUnitAmount<>(dividedByScalar(other, mathContext), unit);
	}

	@Override
	public BigDecimalAmount getAmountIn(U newUnit) {
		if (unit.equals(newUnit))
		{
			return amount;
		}

		Function<BigDecimalAmount, BigDecimalAmount> translation = getUnit()
				.getTranslationToCanonical()
				.andThen(newUnit.getTranslationFromCanonical());

		return amount.transformed(translation);
	}

	@Override
	public BigDecimalAmount getAmountIn(Magnitude magnitude, U newUnit) {
		if (unit.equals(newUnit))
		{
			return amount.dividedBy(magnitude.getValue(), UNLIMITED);
		}

		Function<BigDecimalAmount, BigDecimalAmount> translation = getUnit()
				.getTranslationToCanonical()
				.andThen(newUnit.getTranslationFromCanonical());

		return amount.transformed(translation).dividedBy(magnitude.getValue(), UNLIMITED);
	}

	@Override
	public UnitAmount<U> in(U unit) {
		return null;
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitAmount) {
			CompositeUnitAmount<?> that = (CompositeUnitAmount<?>) obj;

			return Objects.equals(this.amount, that.amount) &&
					Objects.equals(this.unit, that.unit);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, unit);
	}

	@Override
	public String toString() {
		return amount.toString() + (unit.isScalar() ? "" : " " + unit.toString());
	}

	// endregion
}
