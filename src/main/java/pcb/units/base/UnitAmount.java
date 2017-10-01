package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.MathContext;

public interface UnitAmount<N extends Number, U extends Unit<N, U>, UA extends UnitAmount<N, U, UA>> {
	Amount<N> getAmount();
	U getUnit();

	UA plus(UA other, MathContext mathContext);
	UA minus(UA other, MathContext mathContext);
	UA multipliedBy(Amount<N> other, MathContext mathContext);
	UA dividedBy(Amount<N> other, MathContext mathContext);
	Amount<N> dividedBy(UA other, MathContext mathContext);
	N getValueIn(U unit);
}
