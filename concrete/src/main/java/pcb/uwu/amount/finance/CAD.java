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

public class CAD extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("CAD");

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
	public CAD plus(UnitAmount<CurrencyUnit> other, MathContext mathContext) {
		return new CAD(plusAmount(this, other, mathContext));
	}

	@Override
	public CAD minus(UnitAmount<CurrencyUnit> other, MathContext mathContext) {
		return new CAD(minusAmount(this, other, mathContext));
	}

	@Override
	public CAD multipliedBy(BigDecimal other, MathContext mathContext) {
		return new CAD(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public CAD dividedBy(BigDecimal other, MathContext mathContext) {
		return new CAD(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
