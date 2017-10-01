package pcb.units.base;

import pcb.units.amount.Amount;

import java.math.MathContext;
import java.util.function.Function;

public interface UnitAmount<U extends Unit<U>, N extends Number> {
	Amount<N> getAmount();
	Function<UnitAmount<U, N>, UnitAmount<U, N>> translationToCanonical();
	Function<UnitAmount<U, N>, UnitAmount<U, N>> translationFromCanonical();

//	<U extends SpaceUnit> U convertTo(U unit);

	UnitAmount<U, N> plus(UnitAmount<U, N> other, MathContext mathContext);
	UnitAmount<U, N> minus(UnitAmount<U, N> other, MathContext mathContext);
	UnitAmount<U, N> multipliedBy(N other, MathContext mathContext);
	UnitAmount<U, N> dividedBy(N other, MathContext mathContext);
	N dividedBy(UnitAmount<U, N> other, MathContext mathContext);
}
