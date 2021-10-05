package pcb.uwu.amount.finance;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.CurrencyUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class GBP extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("GBP");

	// region constructor

	public GBP(Number value) {
		super(value, CURRENCY);
	}

	public GBP(String value) {
		super(value, CURRENCY);
	}

	public GBP(BigDecimal value) {
		super(value, CURRENCY);
	}

	public GBP(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public GBP plus(GBP other) {
		return new GBP(getAmount().plus(other.getAmount().getValue()));
	}

	public GBP minus(GBP other) {
		return new GBP(getAmount().minus(other.getAmount().getValue()));
	}

	@NotNull
	@Override
	public GBP plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new GBP(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Money minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new GBP(minusAmount(this, other));
	}

	@NotNull
	@Override
	public GBP times(@NotNull Number other) {
		return new GBP(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public GBP div(@NotNull Number other) {
		return new GBP(dividedByScalar(this, other));
	}

	// endregion
}
