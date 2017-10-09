package pcb.uwu.amount.finance;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.finance.RentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Rent extends AbstractUnitAmount<RentUnit> {

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
	public Rent convertTo(RentUnit unit) {
		return new Rent(getAmountIn(unit), unit);
	}

	// endregion

	// composite
}
