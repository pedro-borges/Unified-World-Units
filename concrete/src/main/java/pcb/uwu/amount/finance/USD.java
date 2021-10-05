package pcb.uwu.amount.finance;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.Amount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.CurrencyUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class USD extends Currency {

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

	public USD(Amount amount) {
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
	public USD plus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new USD(plusAmount(this, currency));
	}

	@NotNull
	@Override
	public USD minus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new USD(minusAmount(this, currency));
	}

	@NotNull
	@Override
	public USD times(@NotNull Number scalar) {
		return new USD(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public USD div(@NotNull Number scalar) {
		return new USD(dividedByScalar(this, scalar));
	}

	// endregion
}
