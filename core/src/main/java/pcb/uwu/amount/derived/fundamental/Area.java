package pcb.uwu.amount.derived.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.derived.fundamental.AreaUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Area extends CompositeUnitAmount<AreaUnit> {

	// region constructors

	public Area(Number value, AreaUnit unit) {
		super(value, unit);
	}

	public Area(Number value, Magnitude magnitude, AreaUnit unit) {
		super(value, magnitude, unit);
	}

	public Area(String value, AreaUnit unit) {
		super(value, unit);
	}

	public Area(String value, Magnitude magnitude, AreaUnit unit) {
		super(value, magnitude, unit);
	}

	public Area(BigDecimal value, AreaUnit unit) {
		super(value, unit);
	}

	public Area(BigDecimal value, Magnitude magnitude, AreaUnit unit) {
		super(value, magnitude, unit);
	}

	public Area(BigDecimalAmount amount, AreaUnit unit) {
		super(amount, unit);
	}

	public Area(BigDecimalAmount amount, Magnitude magnitude, AreaUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Area plus(UnitAmount<AreaUnit> other, MathContext mathContext) {
		return new Area(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Area minus(UnitAmount<AreaUnit> other, MathContext mathContext) {
		return new Area(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Area multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Area(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Area dividedBy(BigDecimal other, MathContext mathContext) {
		return new Area(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Area convertTo(AreaUnit unit) {
		return new Area(getAmountIn(unit), unit);
	}

	// endregion
}
