package pcb.uwu.amount.derived.finance;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.finance.Money;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.FrequencyUnit;
import pcb.uwu.unit.finance.CurrencyUnit;
import pcb.uwu.unit.finance.RentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class InterestRate extends CompositeUnitAmount<FrequencyUnit> {

	// region constructors

	public InterestRate(Number value, FrequencyUnit unit) {
		super(value, unit);
	}

	public InterestRate(Number value, Magnitude magnitude, FrequencyUnit unit) {
		super(value, magnitude, unit);
	}

	public InterestRate(String value, FrequencyUnit unit) {
		super(value, unit);
	}

	public InterestRate(String value, Magnitude magnitude, FrequencyUnit unit) {
		super(value, magnitude, unit);
	}

	public InterestRate(BigDecimal value, FrequencyUnit unit) {
		super(value, unit);
	}

	public InterestRate(BigDecimal value, Magnitude magnitude, FrequencyUnit unit) {
		super(value, magnitude, unit);
	}

	public InterestRate(BigDecimalAmount amount, FrequencyUnit unit) {
		super(amount, unit);
	}

	public InterestRate(BigDecimalAmount amount, Magnitude magnitude, FrequencyUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public InterestRate plus(@NotNull UnitAmount<FrequencyUnit> other) {
		return new InterestRate(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public InterestRate minus(@NotNull UnitAmount<FrequencyUnit> other) {
		return new InterestRate(minusAmount(this, other), getUnit());
	}

	@Override
	public InterestRate multiply(BigDecimal other, MathContext mathContext) {
		return new InterestRate(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public InterestRate div(BigDecimal other, MathContext mathContext) {
		return new InterestRate(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public InterestRate into(FrequencyUnit unit) {
		return new InterestRate(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	public Rent multipliedBy(Money money, MathContext mathContext) {
		BigDecimalAmount amount = multipliedByScalar(this, money.getAmount().getValue(), mathContext);
		RentUnit unit = new RentUnit(money.getUnit(), getUnit());

		return new Rent(amount, unit);
	}

	public Money multipliedBy(Debt debt, MathContext mathContext) {
		BigDecimalAmount amount = super.multiply(debt, mathContext).getAmount();
		CurrencyUnit unit = getUnit().getUnitCounter().findUnit(CurrencyUnit.class);

		return new Money(amount, unit);
	}

	// endregion
}
