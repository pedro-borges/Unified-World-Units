package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.CurrencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class USD extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("USD");

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
	public USD plus(UnitAmount<CurrencyUnit> other, MathContext mathContext) {
		return new USD(plusAmount(this, other, mathContext));
	}

	@Override
	public USD minus(UnitAmount<CurrencyUnit> other, MathContext mathContext) {
		return new USD(minusAmount(this, other, mathContext));
	}

	@Override
	public USD multipliedBy(BigDecimal other, MathContext mathContext) {
		return new USD(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public USD dividedBy(BigDecimal other, MathContext mathContext) {
		return new USD(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
