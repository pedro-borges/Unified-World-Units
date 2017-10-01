package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.Objects;

public abstract class AbstractUnitAmount<U extends Unit>
		implements UnitAmount<U> {

	// region private fields

	private final Amount amount;
	private final U unit;

	// endregion

	// region constructors

	public AbstractUnitAmount(
			Amount amount,
			U unit) {

		this.amount = amount;
		this.unit = unit;
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Amount getAmount() {
		return amount;
	}

	@Override
	public U getUnit() {
		return unit;
	}

	@Override
	public Amount getAmountIn(U newUnit) {
		if (getUnit().equals(newUnit)) {
			return amount;
		}

		return getUnit().getTranslationToCanonical().andThen(newUnit.getTranslationFromCanonical()).apply(amount);
	}

	// endregion

	// override Object

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

	// endregion
}
