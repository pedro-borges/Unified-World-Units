package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TemperatureUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.CelsiusUnit.CELSIUS;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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

	@NotNull
	@Override
	public Celsius times(@NotNull Number other) {
		return new Celsius(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Celsius div(@NotNull Number other) {
		return new Celsius(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	// endregion
}
