package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Temperature
		extends AbstractUnitAmount<BigDecimalAmount, TemperatureUnit>
		implements UnitAmount<BigDecimalAmount, TemperatureUnit> {

	// region constructors

	public Temperature(Number value, TemperatureUnit unit) {
		this(value.toString(), unit);
	}

	public Temperature(String value, TemperatureUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Temperature(BigDecimal value, TemperatureUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Temperature(BigDecimalAmount amount, TemperatureUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Temperature plus(UnitAmount<BigDecimalAmount, TemperatureUnit> other, MathContext mathContext) {
		return new Temperature(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Temperature minus(UnitAmount<BigDecimalAmount, TemperatureUnit> other, MathContext mathContext) {
		return new Temperature(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Temperature multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Temperature(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Temperature dividedBy(BigDecimal other, MathContext mathContext) {
		return new Temperature(dividedByAmount(other, mathContext), getUnit());
	}

	// endregion
}
