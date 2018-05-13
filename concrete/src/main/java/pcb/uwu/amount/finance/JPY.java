package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class JPY extends Money {

	public static final MoneyUnit CURRENCY = MoneyUnit.of("JPY");

	// region constructor

	public JPY(Number value) {
		super(value, CURRENCY);
	}

	public JPY(String value) {
		super(value, CURRENCY);
	}

	public JPY(BigDecimal value) {
		super(value, CURRENCY);
	}

	public JPY(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public JPY plus(JPY other) {
		return new JPY(getAmount().plus(other.getAmount().getValue()));
	}

	public JPY minus(JPY other) {
		return new JPY(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public JPY plus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new JPY(plusAmount(other, mathContext));
	}

	@Override
	public JPY minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new JPY(minusAmount(other, mathContext));
	}

	@Override
	public JPY multipliedBy(BigDecimal other, MathContext mathContext) {
		return new JPY(multipliedByScalar(other, mathContext));
	}

	@Override
	public JPY dividedBy(BigDecimal other, MathContext mathContext) {
		return new JPY(dividedByScalar(other, mathContext));
	}

	// endregion
}
