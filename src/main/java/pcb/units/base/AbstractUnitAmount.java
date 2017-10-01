package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.function.Function;

public abstract class AbstractUnitAmount<U extends Unit<U>, N extends Number>
		implements UnitAmount<U, N> {

	// region private fields

	private final Amount<N> amount;
	private final Unit<U> unit;
	private final Function<UnitAmount<U, N>, UnitAmount<U, N>> translationToCanonical;
	private final Function<UnitAmount<U, N>, UnitAmount<U, N>> translationFromCanonical;

	// endregion

	// region constructors

	public AbstractUnitAmount(
			Amount<N> amount,
			Unit<U> unit,
			Function<UnitAmount<U, N>, UnitAmount<U, N>> translationToCanonical,
			Function<UnitAmount<U, N>, UnitAmount<U, N>> translationFromCanonical) {

		this.amount = amount;
		this.unit = unit;
		this.translationToCanonical = translationToCanonical;
		this.translationFromCanonical = translationFromCanonical;
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Amount<N> getAmount() {
		return amount;
	}

	@Override
	public Function<UnitAmount<U, N>, UnitAmount<U, N>> translationToCanonical() {
		return translationToCanonical;
	}

	@Override
	public Function<UnitAmount<U, N>, UnitAmount<U, N>> translationFromCanonical() {
		return translationFromCanonical;
	}

	protected UnitAmount<U, N> convertToSelfScale(UnitAmount<U, N> other) {
		return other.translationToCanonical().andThen(translationFromCanonical()).apply(other);
	}

	// endregion
}
