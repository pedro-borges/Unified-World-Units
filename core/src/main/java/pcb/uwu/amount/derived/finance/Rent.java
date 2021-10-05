package pcb.uwu.amount.derived.finance;

import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.finance.Money;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.CurrencyUnit;
import pcb.uwu.unit.finance.RentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new Rent(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Rent minus(UnitAmount<RentUnit> other, MathContext mathContext) {
		return new Rent(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Rent multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Rent(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Rent dividedBy(BigDecimal other, MathContext mathContext) {
		return new Rent(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Rent in(RentUnit unit) {
		return new Rent(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	public Money multipliedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = super.multipliedBy(time, mathContext).getAmount();
		CurrencyUnit unit = getUnit().getUnitCounter().findUnit(CurrencyUnit.class);

		return new Money(amount, unit);
	}

	// endregion
}
