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

public class CAD extends Money {

	public static final CurrencyUnit CURRENCY = CurrencyUnit.of("CAD");

	// region constructor

	public CAD(Number value) {
		super(value, CURRENCY);
	}

	public CAD(String value) {
		super(value, CURRENCY);
	}

	public CAD(BigDecimal value) {
		super(value, CURRENCY);
	}

	public CAD(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public CAD plus(CAD other) {
		return new CAD(getAmount().plus(other.getAmount().getValue()));
	}

	public CAD minus(CAD other) {
		return new CAD(getAmount().minus(other.getAmount().getValue()));
	}

	@NotNull
	@Override
	public CAD plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new CAD(plusAmount(this, other));
	}

	@NotNull
	@Override
	public CAD minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new CAD(minusAmount(this, other));
	}

	@NotNull
	@Override
	public CAD times(@NotNull Number other) {
		return new CAD(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public CAD div(@NotNull Number other) {
		return new CAD(dividedByScalar(this, other));
	}

	// endregion
}
