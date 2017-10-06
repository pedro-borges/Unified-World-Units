package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Temperature extends AbstractUnitAmount<TemperatureUnit> {

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
		return new Temperature(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Temperature minus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Temperature(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Temperature multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Temperature(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Temperature dividedBy(BigDecimal other, MathContext mathContext) {
		return new Temperature(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Temperature convertTo(TemperatureUnit unit) {
		return new Temperature(getAmountIn(unit), unit);
	}

	// endregion
}
