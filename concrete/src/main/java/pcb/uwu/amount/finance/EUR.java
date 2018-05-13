package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class EUR extends Money {

	public static final MoneyUnit CURRENCY = MoneyUnit.of("EUR");

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
	public EUR plus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new EUR(plusAmount(other, mathContext));
	}

	@Override
	public Money minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new AUD(minusAmount(other, mathContext));
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
