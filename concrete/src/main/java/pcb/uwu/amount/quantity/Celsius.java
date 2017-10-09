package pcb.uwu.amount.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.CelsiusUnit.CELSIUS;

public class Celsius extends Temperature {

	// region constructors

	public Celsius(Number value) {
		super(value, CELSIUS);
	}

	public Celsius(Number value, Magnitude magnitude) {
		super(value, magnitude, CELSIUS);
	}

	public Celsius(String value) {
		super(value, CELSIUS);
	}

	public Celsius(String value, Magnitude magnitude) {
		super(value, magnitude, CELSIUS);
	}

	public Celsius(BigDecimal value) {
		super(value, CELSIUS);
	}

	public Celsius(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, CELSIUS);
	}

	public Celsius(BigDecimalAmount amount) {
		super(amount, CELSIUS);
	}

	public Celsius(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, CELSIUS);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Celsius plus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Celsius(plusAmount(other, mathContext));
	}

	@Override
	public Celsius minus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Celsius(minusAmount(other, mathContext));
	}

	@Override
	public Celsius multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Celsius(multipliedByScalar(other, mathContext));
	}

	@Override
	public Celsius dividedBy(BigDecimal other, MathContext mathContext) {
		return new Celsius(dividedByScalar(other, mathContext));
	}

	// endregion
}
