package pcb.uwu.amount.finance;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.CurrencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class CHF extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("CHF");

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

	@NotNull
	@Override
	public CHF plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new CHF(plusAmount(this, other));
	}

	@NotNull
	@Override
	public CHF minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new CHF(minusAmount(this, other));
	}

	@Override
	public CHF times(BigDecimal other, MathContext mathContext) {
		return new CHF(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public CHF div(BigDecimal other, MathContext mathContext) {
		return new CHF(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
