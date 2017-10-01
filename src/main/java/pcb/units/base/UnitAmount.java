package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.MathContext;

public interface UnitAmount<U extends Unit> {
	Amount getAmount();
	U getUnit();

	UnitAmount<U> plus(UnitAmount<U> other, MathContext mathContext);
	UnitAmount<U> minus(UnitAmount<U> other, MathContext mathContext);
	UnitAmount<U> multipliedBy(Amount other, MathContext mathContext);
	UnitAmount<U> dividedBy(Amount other, MathContext mathContext);
	Amount dividedBy(UnitAmount<U> other, MathContext mathContext);
	Amount getAmountIn(U unit);
}
