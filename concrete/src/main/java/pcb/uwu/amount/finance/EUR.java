package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

public class EUR extends Money {

	public static final Currency CURRENCY = Currency.getInstance("EUR");

	// region constructor

	public EUR(Number value) {
		super(value, CURRENCY);
	}

	public EUR(String value) {
		super(value, CURRENCY);
	}

	public EUR(BigDecimal value) {
		super(value, CURRENCY);
	}

	public EUR(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public EUR plus(EUR other) {
		return new EUR(getAmount().plus(other.getAmount().getValue()));
	}

	public EUR minus(EUR other) {
		return new EUR(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public EUR multipliedBy(BigDecimal other, MathContext mathContext) {
		return new EUR(multipliedByScalar(other, mathContext));
	}

	@Override
	public EUR dividedBy(BigDecimal other, MathContext mathContext) {
		return new EUR(dividedByScalar(other, mathContext));
	}

	// endregion
}
