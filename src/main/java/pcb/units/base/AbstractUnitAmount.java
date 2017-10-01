package pcb.units.base;

import pcb.units.amount.Amount;

public abstract class AbstractUnitAmount<N extends Number, A extends Amount<N>, U extends Unit<N, U>, UA extends UnitAmount<N, A, U, UA>>
		implements UnitAmount<N, A, U, UA> {

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
	public N getValueIn(U unit) {
		return getUnit().translationToCanonical().andThen(unit.translationFromCanonical()).apply(amount.getValue());
	}

	// endregion
}
