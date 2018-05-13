package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

public class CAD extends Money {

	public static final Currency CURRENCY = Currency.getInstance("CAD");

	// region constructor

	public CAD(Number value) {
		super(value, CURRENCY);
	}

	public CAD(String value) {
		super(value, CURRENCY);
	}

	public CAD(BigDecimal value) {
		super(value, CURRENCY);
	}

	public CAD(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public CAD plus(CAD other) {
		return new CAD(getAmount().plus(other.getAmount().getValue()));
	}

	public CAD minus(CAD other) {
		return new CAD(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public CAD multipliedBy(BigDecimal other, MathContext mathContext) {
		return new CAD(multipliedByScalar(other, mathContext));
	}

	@Override
	public CAD dividedBy(BigDecimal other, MathContext mathContext) {
		return new CAD(dividedByScalar(other, mathContext));
	}

	// endregion
}
