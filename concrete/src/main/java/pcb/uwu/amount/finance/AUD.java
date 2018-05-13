package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class AUD extends Money {

	public static final MoneyUnit CURRENCY = MoneyUnit.of("AUD");

	// region constructor

	public AUD(Number value) {
		super(value, CURRENCY);
	}

	public AUD(String value) {
		super(value, CURRENCY);
	}

	public AUD(BigDecimal value) {
		super(value, CURRENCY);
	}

	public AUD(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public AUD plus(AUD other) {
		return new AUD(getAmount().plus(other.getAmount().getValue()));
	}

	public AUD minus(AUD other) {
		return new AUD(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public AUD plus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new AUD(plusAmount(other, mathContext));
	}

	@Override
	public AUD minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new AUD(minusAmount(other, mathContext));
	}

	@Override
	public AUD multipliedBy(BigDecimal other, MathContext mathContext) {
		return new AUD(multipliedByScalar(other, mathContext));
	}

	@Override
	public AUD dividedBy(BigDecimal other, MathContext mathContext) {
		return new AUD(dividedByScalar(other, mathContext));
	}

	// endregion
}
