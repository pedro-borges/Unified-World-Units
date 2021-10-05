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

public class EUR extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("EUR");

	// region constructor

	public EUR(Number value) {
		super(value, CURRENCY);
	}

	public EUR(String value) {
		super(value, CURRENCY);
	}

	public EUR(BigDecimal value) {
		super(value, CURRENCY);
	}

	public EUR(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public EUR plus(EUR other) {
		return new EUR(getAmount().plus(other.getAmount().getValue()));
	}

	public EUR minus(EUR other) {
		return new EUR(getAmount().minus(other.getAmount().getValue()));
	}

	@NotNull
	@Override
	public EUR plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new EUR(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Money minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new AUD(minusAmount(this, other));
	}

	@NotNull
	@Override
	public EUR times(@NotNull Number other) {
		return new EUR(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public EUR div(@NotNull Number other) {
		return new EUR(dividedByScalar(this, other));
	}

	// endregion
}
