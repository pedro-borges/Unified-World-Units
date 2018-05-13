package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

public class GBP extends Money {

	public static final Currency CURRENCY = Currency.getInstance("GBP");

	// region constructor

	public GBP(Number value) {
		super(value, CURRENCY);
	}

	public GBP(String value) {
		super(value, CURRENCY);
	}

	public GBP(BigDecimal value) {
		super(value, CURRENCY);
	}

	public GBP(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public GBP plus(GBP other) {
		return new GBP(getAmount().plus(other.getAmount().getValue()));
	}

	public GBP minus(GBP other) {
		return new GBP(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public GBP multipliedBy(BigDecimal other, MathContext mathContext) {
		return new GBP(multipliedByScalar(other, mathContext));
	}

	@Override
	public GBP dividedBy(BigDecimal other, MathContext mathContext) {
		return new GBP(dividedByScalar(other, mathContext));
	}

	// endregion
}
