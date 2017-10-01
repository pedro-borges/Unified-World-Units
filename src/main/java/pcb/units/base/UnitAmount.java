package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.MathContext;

public interface UnitAmount<N extends Number, A extends Amount<N>, U extends Unit<N, U>, UA extends UnitAmount<N, A, U, UA>> {
	A getAmount();
	U getUnit();

	UA plus(UA other, MathContext mathContext);
	UA minus(UA other, MathContext mathContext);
	UA multipliedBy(A other, MathContext mathContext);
	UA dividedBy(A other, MathContext mathContext);
	Amount<N> dividedBy(UA other, MathContext mathContext);
	N getValueIn(U unit);
}
