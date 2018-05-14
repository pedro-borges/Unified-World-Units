package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Temperature extends CompositeUnitAmount<TemperatureUnit> {

	// region constructors

	public Temperature(Number value, TemperatureUnit unit) {
		super(value, unit);
	}

	public Temperature(Number value, Magnitude magnitude, TemperatureUnit unit) {
		super(value, magnitude, unit);
	}

	public Temperature(String value, TemperatureUnit unit) {
		super(value, unit);
	}

	public Temperature(String value, Magnitude magnitude, TemperatureUnit unit) {
		super(value, magnitude, unit);
	}

	public Temperature(BigDecimal value, TemperatureUnit unit) {
		super(value, unit);
	}

	public Temperature(BigDecimal value, Magnitude magnitude, TemperatureUnit unit) {
		super(value, magnitude, unit);
	}

	public Temperature(BigDecimalAmount amount, TemperatureUnit unit) {
		super(amount, unit);
	}

	public Temperature(BigDecimalAmount amount, Magnitude magnitude, TemperatureUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Temperature plus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Temperature(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Temperature minus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Temperature(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Temperature multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Temperature(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Temperature dividedBy(BigDecimal other, MathContext mathContext) {
		return new Temperature(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Temperature in(TemperatureUnit unit) {
		return new Temperature(getAmountIn(this, unit), unit);
	}

	// endregion
}
