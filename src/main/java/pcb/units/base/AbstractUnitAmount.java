package pcb.units.base;

import pcb.units.amount.Amount;

public abstract class AbstractUnitAmount<N extends Number, U extends Unit<N, U>>
		implements UnitAmount<N, U> {

	// region private fields

	private final Amount<N> amount;
	private final U unit;

	// endregion

	// region constructors

	public AbstractUnitAmount(
			Amount<N> amount,
			U unit) {

		this.amount = amount;
		this.unit = unit;
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Amount<N> getAmount() {
		return amount;
	}

	@Override
	public U getUnit() {
		return unit;
	}

	@Override
	public Amount<N> getAmountIn(U newUnit) {
		return getUnit().translationToCanonical().andThen(newUnit.translationFromCanonical()).apply(amount);
	}

	// endregion
}
