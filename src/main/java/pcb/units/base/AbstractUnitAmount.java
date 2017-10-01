package pcb.units.base;

import pcb.units.amount.Amount;

import java.util.function.Function;

public abstract class AbstractUnitAmount<N extends Number, U extends Unit<N, U>, UA extends UnitAmount<N, U, UA>>
		implements UnitAmount<N, U, UA> {

	// region private fields

	private final Amount<N> amount;
	private final Unit<N, U> unit;
	private final Function<UA, UA> translationToCanonical;
	private final Function<UA, UA> translationFromCanonical;

	// endregion

	// region constructors

	public AbstractUnitAmount(
			Amount<N> amount,
			Unit<N, U> unit,
			Function<UA, UA> translationToCanonical,
			Function<UA, UA> translationFromCanonical) {

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
	public Function<UA, UA> translationToCanonical() {
		return translationToCanonical;
	}

	@Override
	public Function<UA, UA> translationFromCanonical() {
		return translationFromCanonical;
	}

	protected UA convertToSelfScale(UA other) {
		return other.translationToCanonical().andThen(translationFromCanonical()).apply(other);
	}

	// endregion
}
