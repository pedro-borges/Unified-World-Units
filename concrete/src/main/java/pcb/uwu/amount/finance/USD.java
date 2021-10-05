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

	@NotNull
	@Override
	public USD plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new USD(plusAmount(this, other));
	}

	@NotNull
	@Override
	public USD minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new USD(minusAmount(this, other));
	}

	@NotNull
	@Override
	public USD times(@NotNull Number other) {
		return new USD(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public USD div(@NotNull Number other) {
		return new USD(dividedByScalar(this, other));
	}

	// endregion
}
