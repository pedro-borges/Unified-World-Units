package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.BigDecimal;
import java.math.MathContext;

public interface UnitAmount<A extends Amount<A>, U extends Unit> {
	A getAmount();
	U getUnit();

	UnitAmount<A, U> plus(UnitAmount<A, U> other, MathContext mathContext);
	UnitAmount<A, U> minus(UnitAmount<A, U> other, MathContext mathContext);
	UnitAmount<A, U> multipliedBy(BigDecimal other, MathContext mathContext);
	UnitAmount<A, U> dividedBy(BigDecimal other, MathContext mathContext);
	A getAmountIn(U unit);
}
