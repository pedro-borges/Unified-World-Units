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

public class BTC extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("BTC");

	// region constructor

	public BTC(Number value) {
		super(value, CURRENCY);
	}

	public BTC(String value) {
		super(value, CURRENCY);
	}

	public BTC(BigDecimal value) {
		super(value, CURRENCY);
	}

	public BTC(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public BTC plus(BTC other) {
		return new BTC(getAmount().plus(other.getAmount().getValue()));
	}

	public BTC minus(BTC other) {
		return new BTC(getAmount().minus(other.getAmount().getValue()));
	}

	@NotNull
	@Override
	public BTC plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new BTC(plusAmount(this, other));
	}

	@NotNull
	@Override
	public BTC minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new BTC(minusAmount(this, other));
	}

	@Override
	public BTC multiply(BigDecimal other, MathContext mathContext) {
		return new BTC(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public BTC div(BigDecimal other, MathContext mathContext) {
		return new BTC(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
