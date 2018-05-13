package pcb.uwu.amount.derived.thermodynamics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.PowerUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Power extends CompositeUnitAmount<PowerUnit> {

	// region constructors

	public Power(Number value, PowerUnit unit) {
		super(value, unit);
	}

	public Power(Number value, Magnitude magnitude, PowerUnit unit) {
		super(value, magnitude, unit);
	}

	public Power(String value, PowerUnit unit) {
		super(value, unit);
	}

	public Power(String value, Magnitude magnitude, PowerUnit unit) {
		super(value, magnitude, unit);
	}

	public Power(BigDecimal value, PowerUnit unit) {
		super(value, unit);
	}

	public Power(BigDecimal value, Magnitude magnitude, PowerUnit unit) {
		super(value, magnitude, unit);
	}

	public Power(BigDecimalAmount amount, PowerUnit unit) {
		super(amount, unit);
	}

	public Power(BigDecimalAmount amount, Magnitude magnitude, PowerUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Power plus(UnitAmount<PowerUnit> other, MathContext mathContext) {
		return new Power(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Power minus(UnitAmount<PowerUnit> other, MathContext mathContext) {
		return new Power(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Power multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Power(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Power dividedBy(BigDecimal other, MathContext mathContext) {
		return new Power(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Power convertTo(PowerUnit unit) {
		return new Power(getAmountIn(unit), unit);
	}

	// endregion

}
