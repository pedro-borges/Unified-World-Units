package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new JPY(plusAmount(this, other, mathContext));
	}

	@Override
	public JPY minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new JPY(minusAmount(this, other, mathContext));
	}

	@Override
	public JPY multipliedBy(BigDecimal other, MathContext mathContext) {
		return new JPY(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public JPY dividedBy(BigDecimal other, MathContext mathContext) {
		return new JPY(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
