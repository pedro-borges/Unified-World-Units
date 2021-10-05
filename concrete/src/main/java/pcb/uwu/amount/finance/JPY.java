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

public class JPY extends Currency {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("JPY");

	// region constructor

	public JPY(Number value) {
		super(value, CURRENCY);
	}

	public JPY(String value) {
		super(value, CURRENCY);
	}

	public JPY(BigDecimal value) {
		super(value, CURRENCY);
	}

	public JPY(Amount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public JPY plus(JPY other) {
		return new JPY(getAmount().plus(other.getAmount().getValue()));
	}

	public JPY minus(JPY other) {
		return new JPY(getAmount().minus(other.getAmount().getValue()));
	}

	@NotNull
	@Override
	public JPY plus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new JPY(plusAmount(this, currency));
	}

	@NotNull
	@Override
	public JPY minus(@NotNull UnitAmount<CurrencyUnit> currency) {
		return new JPY(minusAmount(this, currency));
	}

	@NotNull
	@Override
	public JPY times(@NotNull Number scalar) {
		return new JPY(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public JPY div(@NotNull Number scalar) {
		return new JPY(dividedByScalar(this, scalar));
	}

	// endregion
}
