package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

public class CHF extends Money {

	public static final Currency CURRENCY = Currency.getInstance("CHF");

	// region constructor

	public CHF(Number value) {
		super(value, CURRENCY);
	}

	public CHF(String value) {
		super(value, CURRENCY);
	}

	public CHF(BigDecimal value) {
		super(value, CURRENCY);
	}

	public CHF(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public CHF plus(CHF other) {
		return new CHF(getAmount().plus(other.getAmount().getValue()));
	}

	public CHF minus(CHF other) {
		return new CHF(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public CHF multipliedBy(BigDecimal other, MathContext mathContext) {
		return new CHF(multipliedByScalar(other, mathContext));
	}

	@Override
	public CHF dividedBy(BigDecimal other, MathContext mathContext) {
		return new CHF(dividedByScalar(other, mathContext));
	}

	// endregion
}
