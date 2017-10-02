package pcb.units.amount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.Function;

public interface Amount<A extends Amount<A>> {

	BigDecimal getValue();

	int getScale();
	A withScale(int newScale, RoundingMode roundingMode);

	A plus(A other, MathContext mathContext);
	A minus(A other, MathContext mathContext);
	A multipliedBy(BigDecimal other, MathContext mathContext);
	A dividedBy(BigDecimal other, MathContext mathContext);
	A pow(int magnitude, MathContext mathContext);

	A translated(Function<BigDecimal, BigDecimal> translation);
}
