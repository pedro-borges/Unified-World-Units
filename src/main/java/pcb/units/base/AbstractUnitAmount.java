package pcb.units.base;

import pcb.units.amount.Amount;

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
		return getUnit().translationToCanonical().andThen(newUnit.translationFromCanonical()).apply(amount);
	}

	// endregion
}
