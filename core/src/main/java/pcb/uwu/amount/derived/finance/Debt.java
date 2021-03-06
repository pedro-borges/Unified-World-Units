package pcb.uwu.amount.derived.finance;

import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.finance.Money;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.finance.DebtUnit;
import pcb.uwu.unit.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Debt extends CompositeUnitAmount<DebtUnit> {

	// region constructors

	public Debt(Number value, DebtUnit unit) {
		super(value, unit);
	}

	public Debt(Number value, Magnitude magnitude, DebtUnit unit) {
		super(value, magnitude, unit);
	}

	public Debt(String value, DebtUnit unit) {
		super(value, unit);
	}

	public Debt(String value, Magnitude magnitude, DebtUnit unit) {
		super(value, magnitude, unit);
	}

	public Debt(BigDecimal value, DebtUnit unit) {
		super(value, unit);
	}

	public Debt(BigDecimal value, Magnitude magnitude, DebtUnit unit) {
		super(value, magnitude, unit);
	}

	public Debt(BigDecimalAmount amount, DebtUnit unit) {
		super(amount, unit);
	}

	public Debt(BigDecimalAmount amount, Magnitude magnitude, DebtUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Debt plus(UnitAmount<DebtUnit> other, MathContext mathContext) {
		return new Debt(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Debt minus(UnitAmount<DebtUnit> other, MathContext mathContext) {
		return new Debt(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Debt multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Debt(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Debt dividedBy(BigDecimal other, MathContext mathContext) {
		return new Debt(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Debt in(DebtUnit unit) {
		return new Debt(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	public Money multipliedBy(InterestRate interestRate, MathContext mathContext) {
		BigDecimalAmount amount = super.multipliedBy(interestRate, mathContext).getAmount();
		MoneyUnit unit = getUnit().getUnitCounter().findUnit(MoneyUnit.class);

		return new Money(amount, unit);
	}

	public Money dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = super.dividedBy(time, mathContext).getAmount();
		MoneyUnit unit = getUnit().getUnitCounter().findUnit(MoneyUnit.class);

		return new Money(amount, unit);
	}

	public Time dividedBy(Money money, MathContext mathContext) {
		BigDecimalAmount amount = super.dividedBy(money, mathContext).getAmount();
		TimeUnit unit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		return new Time(amount, unit);
	}

	// endregion
}
