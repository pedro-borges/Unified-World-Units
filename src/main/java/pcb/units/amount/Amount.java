package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public abstract class Amount<N extends Number> extends Number {
	public abstract N getValue();

	public abstract int getScale();
	public abstract Amount<N> withScale(int scale, RoundingMode roundingMode);

	public abstract Magnitude getMagnitude();
	public abstract Amount<N> withMagnitude(Magnitude magnitude);
	public abstract Amount<N> withAutoMagnitude();

	public abstract Amount<N> plus(Amount<N> other, MathContext mathContext);
	public abstract Amount<N> minus(Amount<N> other, MathContext mathContext);
	public abstract Amount<N> multipliedBy(N other, MathContext mathContext);
	public abstract Amount<N> multipliedBy(BigDecimal other, MathContext mathContext);
	public abstract Amount<N> dividedBy(N other, MathContext mathContext);
	public abstract Amount<N> dividedBy(BigDecimal other, MathContext mathContext);
	public abstract Amount<N> dividedBy(Amount<N> other, MathContext mathContext);
}
