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

public class AUD extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("AUD");

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
	public AUD plus(UnitAmount<CurrencyUnit> other, MathContext mathContext) {
		return new AUD(plusAmount(this, other, mathContext));
	}

	@Override
	public AUD minus(UnitAmount<CurrencyUnit> other, MathContext mathContext) {
		return new AUD(minusAmount(this, other, mathContext));
	}

	@Override
	public AUD multipliedBy(BigDecimal other, MathContext mathContext) {
		return new AUD(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public AUD dividedBy(BigDecimal other, MathContext mathContext) {
		return new AUD(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
