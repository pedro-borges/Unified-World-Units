package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.BigDecimal;
import java.math.MathContext;

public interface UnitAmount<A extends Amount<A>, U extends Unit> {
	A getAmount();
	U getUnit();

	UnitAmount<A, U> plus(MathContext mathContext, UnitAmount<A, U> other);
	UnitAmount<A, U> minus(MathContext mathContext, UnitAmount<A, U> other);
	UnitAmount<A, U> multipliedBy(MathContext mathContext, BigDecimal other);
	UnitAmount<A, U> dividedBy(MathContext mathContext, BigDecimal other);
	A getAmountIn(U unit);
}
