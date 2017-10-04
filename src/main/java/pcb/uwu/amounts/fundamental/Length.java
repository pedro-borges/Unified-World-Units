package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Length
		extends AbstractUnitAmount<BigDecimalAmount, LengthUnit>
		implements UnitAmount<BigDecimalAmount, LengthUnit> {

	// region constructors

	public Length(Number value, LengthUnit unit) {
		this(value.toString(), unit);
	}

	public Length(String value, LengthUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Length(BigDecimal value, LengthUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Length(BigDecimalAmount amount, LengthUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Length plus(UnitAmount<BigDecimalAmount, LengthUnit> other, MathContext mathContext) {
		return new Length(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Length minus(UnitAmount<BigDecimalAmount, LengthUnit> other, MathContext mathContext) {
		return new Length(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Length multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Length(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Length dividedBy(BigDecimal other, MathContext mathContext) {
		return new Length(dividedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Length convertTo(LengthUnit unit) {
		return new Length(getAmountIn(unit), unit);
	}

	// endregion
}
