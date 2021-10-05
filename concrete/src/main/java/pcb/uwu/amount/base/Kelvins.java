package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TemperatureUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.KelvinUnit.KELVIN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Kelvins plus(@NotNull UnitAmount<TemperatureUnit> temperature) {
		return new Kelvins(plusAmount(this, temperature));
	}

	@NotNull
	@Override
	public Kelvins minus(@NotNull UnitAmount<TemperatureUnit> temperature) {
		return new Kelvins(minusAmount(this, temperature));
	}

	@NotNull
	@Override
	public Kelvins times(@NotNull Number number) {
		return new Kelvins(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Kelvins div(@NotNull Number number) {
		return new Kelvins(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
