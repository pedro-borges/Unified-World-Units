package pcb.uwu.amount.finance;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.finance.Debt;
import pcb.uwu.amount.derived.finance.InterestRate;
import pcb.uwu.amount.derived.finance.Rent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.finance.DebtUnit;
import pcb.uwu.unit.finance.CurrencyUnit;
import pcb.uwu.unit.finance.RentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_EVEN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Money extends CompositeUnitAmount<CurrencyUnit> {

	// region constructors

	public Money(Number value, CurrencyUnit unit) {
		this(value.toString(), unit);
	}

	public Money(String value, CurrencyUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Money(BigDecimal value, CurrencyUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Money(BigDecimalAmount amount, CurrencyUnit unit) {
		super(amount.withScale(unit.getDefaultFractionDigits(), HALF_EVEN), unit);
	}

	// endregion

	//region implement UnitAmount

	@NotNull
	@Override
	public Money plus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new Money(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public Money minus(@NotNull UnitAmount<CurrencyUnit> other) {
		return new Money(minusAmount(this, other), getUnit());
	}

	@Override
	public Money multiply(BigDecimal other, MathContext mathContext) {
		return new Money(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Money div(BigDecimal other, MathContext mathContext) {
		return new Money(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Money into(CurrencyUnit unit) {
		return new Money(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	public Rent dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount().div(time.getAmount().getValue(), mathContext);
		RentUnit unit = new RentUnit(getUnit(), time.getUnit());

		return new Rent(amount, unit);
	}

	public Rent multipliedBy(InterestRate interestRate, MathContext mathContext) {
		BigDecimalAmount amount = getAmount().times(interestRate.getAmount().getValue(), mathContext);
		RentUnit unit = new RentUnit(getUnit(), interestRate.getUnit());

		return new Rent(amount, unit);
	}

	public Debt multipliedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = multipliedByScalar(this, time.getAmount().getValue(), mathContext);
		DebtUnit unit = new DebtUnit(getUnit(), time.getUnit());

		return new Debt(amount, unit);
	}

	// endregion
}
