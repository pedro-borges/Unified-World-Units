package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.MathContext;

public interface UnitAmount<N extends Number, U extends Unit<N, U>> {
	Amount<N> getAmount();
	U getUnit();

	UnitAmount<N, U> plus(UnitAmount<N, U> other, MathContext mathContext);
	UnitAmount<N, U> minus(UnitAmount<N, U> other, MathContext mathContext);
	UnitAmount<N, U> multipliedBy(Amount<N> other, MathContext mathContext);
	UnitAmount<N, U> dividedBy(Amount<N> other, MathContext mathContext);
	Amount<N> dividedBy(UnitAmount<N, U> other, MathContext mathContext);
	Amount<N> getAmountIn(U unit);
}
