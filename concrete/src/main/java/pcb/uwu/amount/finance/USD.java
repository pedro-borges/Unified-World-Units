package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class USD extends Money {

	public static final MoneyUnit CURRENCY = MoneyUnit.of("USD");

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
	public USD plus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new USD(plusAmount(other, mathContext));
	}

	@Override
	public USD minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new USD(minusAmount(other, mathContext));
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
