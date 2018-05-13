package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

public class USD extends Money {

	public static final Currency CURRENCY = Currency.getInstance("USD");

	// region constructor

	public USD(Number value) {
		super(value, CURRENCY);
	}

	public USD(String value) {
		super(value, CURRENCY);
	}

	public USD(BigDecimal value) {
		super(value, CURRENCY);
	}

	public USD(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public USD plus(USD other) {
		return new USD(getAmount().plus(other.getAmount().getValue()));
	}

	public USD minus(USD other) {
		return new USD(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public USD multipliedBy(BigDecimal other, MathContext mathContext) {
		return new USD(multipliedByScalar(other, mathContext));
	}

	@Override
	public USD dividedBy(BigDecimal other, MathContext mathContext) {
		return new USD(dividedByScalar(other, mathContext));
	}

	// endregion
}
