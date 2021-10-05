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

public class CHF extends Currency {

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

	public CHF(Amount amount) {
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
	public CHF plus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new CHF(plusAmount(this, currency));
	}

	@NotNull
	@Override
	public CHF minus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new CHF(minusAmount(this, currency));
	}

	@NotNull
	@Override
	public CHF times(@NotNull Number scalar) {
		return new CHF(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public CHF div(@NotNull Number scalar) {
		return new CHF(dividedByScalar(this, scalar));
	}

	// endregion
}
