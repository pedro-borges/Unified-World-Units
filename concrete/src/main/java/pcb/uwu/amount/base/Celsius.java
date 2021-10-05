package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.CelsiusUnit.CELSIUS;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Celsius plus(@NotNull UnitAmount<TemperatureUnit> other) {
		return new Celsius(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Celsius minus(@NotNull UnitAmount<TemperatureUnit> other) {
		return new Celsius(minusAmount(this, other));
	}

	@Override
	public Celsius times(BigDecimal other, MathContext mathContext) {
		return new Celsius(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Celsius div(BigDecimal other, MathContext mathContext) {
		return new Celsius(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
