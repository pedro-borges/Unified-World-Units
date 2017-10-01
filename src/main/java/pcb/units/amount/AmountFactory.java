package pcb.units.amount;

import java.math.BigDecimal;

public class AmountFactory {
	@SuppressWarnings("unchecked")
	public static <N extends Number> Amount<N> amountOf(N amount) {
		if (amount instanceof BigDecimal) {
			return (Amount<N>) new BigDecimalAmount((BigDecimal) amount);
		}

		return null;
	}
}
