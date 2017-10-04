package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Mass
		extends AbstractUnitAmount<BigDecimalAmount, MassUnit>
		implements UnitAmount<BigDecimalAmount, MassUnit> {

	// region constructors

	public Mass(Number value, MassUnit unit) {
		this(value.toString(), unit);
	}

	public Mass(String value, MassUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Mass(BigDecimal value, MassUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Mass(BigDecimalAmount amount, MassUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Mass plus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Mass(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Mass minus(UnitAmount<BigDecimalAmount, MassUnit> other, MathContext mathContext) {
		return new Mass(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Mass multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Mass(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Mass dividedBy(BigDecimal other, MathContext mathContext) {
		return new Mass(dividedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Mass convertTo(MassUnit unit) {
		return new Mass(getAmountIn(unit), unit);
	}

	// endregion
}
