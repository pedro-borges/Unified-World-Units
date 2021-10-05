package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TemperatureUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.FahrenheitUnit.FAHRENHEIT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Fahrenheits extends Temperature {

	// region constructors

	public Fahrenheits(Number value) {
		super(value, FAHRENHEIT);
	}

	public Fahrenheits(Number value, Magnitude magnitude) {
		super(value, magnitude, FAHRENHEIT);
	}

	public Fahrenheits(String value) {
		super(value, FAHRENHEIT);
	}

	public Fahrenheits(String value, Magnitude magnitude) {
		super(value, magnitude, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimal value) {
		super(value, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimalAmount amount) {
		super(amount, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, FAHRENHEIT);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Fahrenheits plus(@NotNull UnitAmount<TemperatureUnit> temperature) {
		return new Fahrenheits(plusAmount(this, temperature));
	}

	@NotNull
	@Override
	public Fahrenheits minus(@NotNull UnitAmount<TemperatureUnit> temperature) {
		return new Fahrenheits(minusAmount(this, temperature));
	}

	@NotNull
	@Override
	public Fahrenheits times(@NotNull Number number) {
		return new Fahrenheits(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Fahrenheits div(@NotNull Number number) {
		return new Fahrenheits(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
