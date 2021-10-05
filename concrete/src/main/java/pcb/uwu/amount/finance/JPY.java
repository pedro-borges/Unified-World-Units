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

public class JPY extends Money {

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

	public JPY(BigDecimalAmount amount) {
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
	public JPY plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new JPY(plusAmount(this, other));
	}

	@NotNull
	@Override
	public JPY minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new JPY(minusAmount(this, other));
	}

	@Override
	public JPY times(BigDecimal other, MathContext mathContext) {
		return new JPY(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public JPY div(BigDecimal other, MathContext mathContext) {
		return new JPY(dividedByScalar(this, other, mathContext));
	}

	// endregion
}
