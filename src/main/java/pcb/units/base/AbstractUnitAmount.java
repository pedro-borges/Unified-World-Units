package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;
import java.util.function.Function;

public abstract class AbstractUnitAmount<A extends Amount<A>, U extends Unit>
		implements UnitAmount<A, U> {

	// region private fields

	private final A amount;
	private final U unit;

	// endregion

	// region constructors

	public AbstractUnitAmount(
			A amount,
			U unit) {

		this.amount = amount;
		this.unit = unit;
	}

	// endregion

	// region implement UnitAmount

	@Override
	public A getAmount() {
		return amount;
	}

	@Override
	public U getUnit() {
		return unit;
	}

	@Override
	public A getAmountIn(U newUnit) {
		if (getUnit().equals(newUnit)) {
			return amount;
		}

		Function<BigDecimal, BigDecimal> translation = getUnit().getTranslationToCanonical().andThen(newUnit.getTranslationFromCanonical());

		return amount.translated(translation);
	}

	// endregion

	// override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitAmount) {
			AbstractUnitAmount<?, ?> other = (AbstractUnitAmount<?, ?>) obj;

			return Objects.equals(this.amount, other.amount) &&
					Objects.equals(this.unit, other.unit);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, unit);
	}

	// endregion

	// region

	protected A plusAmount(MathContext mathContext, UnitAmount<A, U> other) {
		return getAmount().plus(other.getAmountIn(getUnit()), mathContext);
	}

	protected A minusAmount(MathContext mathContext, UnitAmount<A, U> other) {
		return getAmount().minus(other.getAmountIn(getUnit()), mathContext);
	}

	protected A multipliedByAmount(MathContext mathContext, BigDecimal other) {
		return getAmount().multipliedBy(other, mathContext);
	}

	protected A dividedByAmount(MathContext mathContext, BigDecimal other) {
		return getAmount().dividedBy(other, mathContext);
	}

	// endregion
}
