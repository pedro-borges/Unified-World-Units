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

public class AUD extends Currency {

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

	public AUD(Amount amount) {
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

	@NotNull
	@Override
	public AUD plus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new AUD(plusAmount(this, currency));
	}

	@NotNull
	@Override
	public AUD minus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new AUD(minusAmount(this, currency));
	}

	@NotNull
	@Override
	public AUD times(@NotNull Number scalar) {
		return new AUD(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public AUD div(@NotNull Number scalar) {
		return new AUD(dividedByScalar(this, scalar));
	}

	// endregion
}
