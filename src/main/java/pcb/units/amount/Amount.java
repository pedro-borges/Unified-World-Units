package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public abstract class Amount<N extends Number> extends Number {
	public abstract N getValue();

	public abstract boolean isPositive();
	public abstract boolean isZero();
	public abstract boolean isNegative();

	public abstract Amount<N> plus(Amount<N> other, MathContext mathContext);
	public abstract Amount<N> minus(Amount<N> other, MathContext mathContext);
	public abstract Amount<N> multipliedBy(N other, MathContext mathContext);
	public abstract Amount<N> multipliedBy(BigDecimal other, MathContext mathContext);
	public abstract Amount<N> dividedBy(N other, MathContext mathContext);
	public abstract Amount<N> dividedBy(BigDecimal other, MathContext mathContext);
	public abstract Amount<N> dividedBy(Amount<N> other, MathContext mathContext);

	public abstract String toDecimalPrefixedString(List<Magnitude> magnitudes);
}
