package pcb.uwu.amount.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.KelvinUnit.KELVIN;

public class Kelvins extends Temperature {

	// region constructors

	public Kelvins(Number value) {
		super(value, KELVIN);
	}

	public Kelvins(Number value, Magnitude magnitude) {
		super(value, magnitude, KELVIN);
	}

	public Kelvins(String value) {
		super(value, KELVIN);
	}

	public Kelvins(String value, Magnitude magnitude) {
		super(value, magnitude, KELVIN);
	}

	public Kelvins(BigDecimal value) {
		super(value, KELVIN);
	}

	public Kelvins(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, KELVIN);
	}

	public Kelvins(BigDecimalAmount amount) {
		super(amount, KELVIN);
	}

	public Kelvins(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, KELVIN);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Kelvins plus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Kelvins(plusAmount(other, mathContext));
	}

	@Override
	public Kelvins minus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Kelvins(minusAmount(other, mathContext));
	}

	@Override
	public Kelvins multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Kelvins(multipliedByScalar(other, mathContext));
	}

	@Override
	public Kelvins dividedBy(BigDecimal other, MathContext mathContext) {
		return new Kelvins(dividedByScalar(other, mathContext));
	}

	// endregion
}
