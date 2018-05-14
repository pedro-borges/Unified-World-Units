package pcb.uwu.amount.derived.finance;

import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.finance.Money;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;
import pcb.uwu.unit.finance.RentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Rent extends CompositeUnitAmount<RentUnit> {

	// region constructors

	public Rent(Number value, RentUnit unit) {
		super(value, unit);
	}

	public Rent(Number value, Magnitude magnitude, RentUnit unit) {
		super(value, magnitude, unit);
	}

	public Rent(String value, RentUnit unit) {
		super(value, unit);
	}

	public Rent(String value, Magnitude magnitude, RentUnit unit) {
		super(value, magnitude, unit);
	}

	public Rent(BigDecimal value, RentUnit unit) {
		super(value, unit);
	}

	public Rent(BigDecimal value, Magnitude magnitude, RentUnit unit) {
		super(value, magnitude, unit);
	}

	public Rent(BigDecimalAmount amount, RentUnit unit) {
		super(amount, unit);
	}

	public Rent(BigDecimalAmount amount, Magnitude magnitude, RentUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Rent plus(UnitAmount<RentUnit> other, MathContext mathContext) {
		return new Rent(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Rent minus(UnitAmount<RentUnit> other, MathContext mathContext) {
		return new Rent(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Rent multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Rent(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Rent dividedBy(BigDecimal other, MathContext mathContext) {
		return new Rent(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Rent in(RentUnit unit) {
		return new Rent(getAmountIn(unit), unit);
	}

	// endregion

	// region derived

	public Money multipliedBy(Time time, MathContext mathContext) {
		MoneyUnit moneyUnit = getUnit().getUnitCounter().findUnit(MoneyUnit.class);

		return new Money(super.multipliedBy(time, mathContext).getAmount(), moneyUnit);
	}

	// endregion
}
