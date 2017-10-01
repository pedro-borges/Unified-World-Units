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

		return getUnit().translationToCanonical().andThen(newUnit.translationFromCanonical()).apply(amount);
	}

	// endregion

	// override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitAmount) {
			UnitAmount other = (UnitAmount) obj;

			return Objects.equals(this.getAmount(), other.getAmount()) &&
					Objects.equals(this.getUnit(), other.getUnit());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, unit);
	}

	// endregion
}
