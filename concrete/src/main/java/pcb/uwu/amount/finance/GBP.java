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

public class GBP extends Currency {

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
	public GBP plus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new GBP(plusAmount(this, currency));
	}

	@NotNull
	@Override
	public Currency minus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new GBP(minusAmount(this, currency));
	}

	@NotNull
	@Override
	public GBP times(@NotNull Number scalar) {
		return new GBP(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public GBP div(@NotNull Number scalar) {
		return new GBP(dividedByScalar(this, scalar));
	}

	// endregion
}
